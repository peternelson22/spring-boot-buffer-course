package com.nelson.microservices.controller;

import com.nelson.microservices.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "Hello World";
    }

    @GetMapping("/user")
    public User user(){
        User user = new User();
        user.setId(1);
        user.setName("Nelson");
        user.setEmail("nelson@gmail.com");

        return user;
    }
}
