package com.joledzki.springbasicblog.controllers;

import com.joledzki.springbasicblog.user.User;
import com.joledzki.springbasicblog.repositories.UserRepository;
import com.joledzki.springbasicblog.security.SecurityPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

    private final UserRepository userRepository;
    private final SecurityPassword securityPassword;

    @Autowired
    public RegisterController(UserRepository userRepository, SecurityPassword securityPassword){
        this.userRepository = userRepository;
        this.securityPassword = securityPassword;
    }

    @RequestMapping("/register")
    public String getRegister(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    @PostMapping("/add-user")
    public String addUser(User user){
        user.setPassword(securityPassword.passwordEncoder().encode(user.getPassword()));
        user.setRole("ROLE_USER");
        userRepository.save(user);
        System.out.println("ADD USER: "+user);
        return "redirect:/register";
    }


}
