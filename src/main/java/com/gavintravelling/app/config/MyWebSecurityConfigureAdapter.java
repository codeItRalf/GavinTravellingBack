package com.gavintravelling.app.config;

import com.gavintravelling.app.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class MyWebSecurityConfigureAdapter extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private MyUserDetailsService myUserDetailsService;
//
//
//    @Override
//    public  void configure(HttpSecurity http) throws Exception {
//          http
//                  .csrf().disable()
//                  .httpBasic()
//                  .and()
//                  .authorizeRequests()
//                  .antMatchers("/rest/**").authenticated()
//                  .antMatchers("/**").permitAll()
//                  .and()
//                  .formLogin();
//    }
//
//
//    @Override
//    public  void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(myUserDetailsService)
//                .passwordEncoder(myUserDetailsService.getEncoder());
//    }
//

}
