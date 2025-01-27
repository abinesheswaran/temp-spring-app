package com.test.my_spring_app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Value("${name}")
    private String name;
    @Value("${age}")
    private int age;

    @GetMapping("/")
    public String test() {
        return "Hello World "+name+" : "+age;
    }
    @PostMapping("/")
    public String testPost() {
        return "Hello World";
    }
}
