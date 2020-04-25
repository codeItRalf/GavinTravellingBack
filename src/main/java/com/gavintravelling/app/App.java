package com.gavintravelling.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@SpringBootApplication
public class App {

// Behövs kanske för Ida
//    @PostConstruct
//    void started(){
//        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
//    }

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("OPTIONS");
        configuration.addAllowedMethod("HEAD");
        configuration.addAllowedMethod("GET");
        configuration.addAllowedMethod("PUT");
        configuration.addAllowedMethod("POST");
        configuration.addAllowedMethod("DELETE");
        configuration.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", configuration);
        return new CorsFilter(source);
    }

@Bean
public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
}

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
