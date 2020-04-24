package com.gavintravelling.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class App {

// Behövs kanske för Ida
//    @PostConstruct
//    void started(){
//        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
//    }


@Bean
public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
}

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
