package com.company.springSecurity.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
//@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {

    private final SuccessUserHandler loginSuccessHandler;
    private final UserDetailsService serviceSecurity;

    public Security(SuccessUserHandler loginSuccessHandler, UserDetailsService serviceSecurity) {
        this.loginSuccessHandler = loginSuccessHandler;
        this.serviceSecurity = serviceSecurity;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers(("/{id}")).access("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
                .antMatchers("/users").access("hasAnyRole('ROLE_ADMIN')")
                .and()
                .formLogin()
                .successHandler(loginSuccessHandler);
        http.csrf().disable();
    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(serviceSecurity);
        return authenticationProvider;
    }
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(serviceSecurity).passwordEncoder(passwordEncoder());
        auth.authenticationProvider(daoAuthenticationProvider());
    }
    //    @Bean
//    public SpringSecurityDialect springSecurityDialect() {
//        return new SpringSecurityDialect();
//    }
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
    //
    @Bean
    public PasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

}
