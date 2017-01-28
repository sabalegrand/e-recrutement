package com.erecrutement.Security;

import com.erecrutement.Entities.User.User;
import com.erecrutement.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userService.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("No user present with username: "+username);
        }else{
            List<String> userRoles= new ArrayList<>();

            user.getRoles().forEach(role -> userRoles.add("ROLE_" + role.getRole()));

            return new CustomUserDetails(user,userRoles);
        }
    }
}
