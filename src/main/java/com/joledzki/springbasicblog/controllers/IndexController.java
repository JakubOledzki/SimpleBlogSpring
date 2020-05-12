package com.joledzki.springbasicblog.controllers;

import com.joledzki.springbasicblog.post.Post;
import com.joledzki.springbasicblog.repositories.PostRepository;
import com.joledzki.springbasicblog.user.User;
import com.joledzki.springbasicblog.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
public class IndexController {

    PostRepository postRepository;
    UserService userService;

    @Autowired
    public IndexController(PostRepository postRepository, UserService userService){
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getIndex(Model model){
        List<Post> posts = postRepository.findAll();
        Collections.reverse(posts);
        model.addAttribute("posts", posts);

        if(userService.checkUserDetails()){
            model.addAttribute("user", userService.getUserDetails());
        }
        else{
            model.addAttribute("user", new User());
        }
        return "index";
    }

}
