package com.erecrutement.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SpringBootWebSecurityConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/entreprise/**").hasRole("ENTREPRISE")
                .antMatchers("/candidat/**").hasRole("CANDIDAT")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().permitAll()
            .and()
            .formLogin().loginPage("/login").defaultSuccessUrl("/")
            .and()
            .logout().logoutSuccessUrl("/")
            .and()
            .exceptionHandling().accessDeniedPage("/errors")
        .and().csrf().disable();
//        http.authorizeRequests().anyRequest().authenticated().and().formLogin().permitAll().loginPage("/login");

    }
}
