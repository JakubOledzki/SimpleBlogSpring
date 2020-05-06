package com.joledzki.springbasicblog.controllers;

import com.joledzki.springbasicblog.post.Post;
import com.joledzki.springbasicblog.repositories.PostRepository;
import com.joledzki.springbasicblog.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostControllers {

    private PostRepository postRepository;
    private UserService userService;

    @Autowired
    public PostControllers(PostRepository postRepository, UserService userService){
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @RequestMapping("/addPost")
    public String addPost(Model model){
        model.addAttribute("post", new Post());
        return "addPost";
    }

    @PostMapping("/createPost")
    public String createPost(Post post){
        post.setUser(userService.getUserDetails());
        postRepository.save(post);
        return "redirect:/";
    }

}
