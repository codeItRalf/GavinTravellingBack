package com.gavintravelling.app.config;

import com.gavintravelling.app.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{


    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .csrf().disable()
//                  .httpBasic()
//                  .and()
//                  .authorizeRequests()
//                  .antMatchers("/rest/**").authenticated()
//                  .antMatchers("/**").permitAll()
//                  .and()
//                  .formLogin();
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/rest/**").authenticated()
                .antMatchers(HttpMethod.POST, "/rest/filterHotel").authenticated()
                .antMatchers(HttpMethod.POST,"/rest/registrera/**").permitAll()
                .and()
                .formLogin();
              //  .loginPage("/rest/login");

    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(myUserDetailsService)
                .passwordEncoder(myUserDetailsService.getEncoder());
    }


}
