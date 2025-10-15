package com.swapnil.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class MyController {


    @RequestMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
