package com.joledzki.springbasicblog.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping("/hello")
    public String getHello(){
        return "Hello World";
    }

}
