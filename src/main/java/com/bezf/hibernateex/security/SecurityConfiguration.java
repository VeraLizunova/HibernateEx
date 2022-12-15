package com.bezf.hibernateex.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Ivanov").password("IvanovPassword").authorities("read")
                .and()
                .withUser("Petrov").password("PetrovPassword").authorities("read", "write", "delete");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeRequests().antMatchers("/hello").permitAll()
                .and()
                .authorizeRequests().antMatchers("/save").hasAuthority("write")
                .and()
                .authorizeRequests().antMatchers("/findById").hasAuthority("read")
                .and()
                .authorizeRequests().antMatchers("/delete").hasAuthority("delete")
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}
