package com.erecrutement.Security;

import com.erecrutement.Entities.User.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;


public class CustomUserDetails extends User implements UserDetails{

    private List<String> userRoles;


    public CustomUserDetails(User user, List<String> roles) {
        super(user);
        this.userRoles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roles= StringUtils.collectionToCommaDelimitedString(userRoles);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }
}
