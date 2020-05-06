package com.joledzki.springbasicblog.controllers;

import com.joledzki.springbasicblog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    UserRepository userRepository;

    @Autowired
    public LoginController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //FOR TESTS
    @RequestMapping("/hello")
    public String getHello(){
        return "helloworld";
    }

    @RequestMapping("/profil")
    public String getProfil(){return "profil";}

    @GetMapping("/loginpage")
    public String getLoginPage(){
        return "loginpage";
    }

}
