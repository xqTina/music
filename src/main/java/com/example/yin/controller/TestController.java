package com.example.yin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "Hello world!";
    }
    public void test2(){
        System.out.println("test");
    }
}
