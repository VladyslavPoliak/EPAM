package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {
//        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@SpringBootApplication
public class FinalSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalSpringApplication.class, args);
    }

}
