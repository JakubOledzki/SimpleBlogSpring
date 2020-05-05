package com.joledzki.springbasicblog.controllers;

import com.joledzki.springbasicblog.user.User;
import com.joledzki.springbasicblog.repositories.UserRepository;
import com.joledzki.springbasicblog.security.SecurityPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import javax.validation.Validation;

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
    public String addUser(@Valid User user, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors() || user.getPassword().length()<6){
            if(user.getPassword().length()<6){

//                bindingResult.addError(new ObjectError("password","Password must have from 6 to 32 chars"));
                model.addAttribute("password_error","Password must have from 6 to 32 chars");
            }
            System.out.println("ERROR");
            return "register";
        }
        else{
            user.setPassword(securityPassword.passwordEncoder().encode(user.getPassword()));
            user.setRole("ROLE_USER");

            userRepository.save(user);
            System.out.println("ADD USER: "+user);
            return "redirect:/register";
        }

    }


}
