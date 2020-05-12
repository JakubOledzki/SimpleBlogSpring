package com.joledzki.springbasicblog.post;

import com.joledzki.springbasicblog.repositories.PostRepository;
import com.joledzki.springbasicblog.user.User;
import com.joledzki.springbasicblog.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private PostRepository postRepository;
    private UserService userService;

    @Autowired
    public PostService(PostRepository postRepository, UserService userService){
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public void deletePost(Long id) throws Exception {

        if(userService.checkUserDetails()) {

            User user = userService.getUserDetails();

            if (postRepository.findById(id).isPresent()) {
                if (postRepository.findById(id).get().getUser().getId() == user.getId()) {
                    postRepository.deleteById(id);
                } else {
                    throw new Exception("ITS NOT YOUR POST");
                }
            } else {
                throw new Exception("POST DOESN'T EXISTS");
            }
        }
        else{
            throw new Exception("YOU MUST BE SIGN IN");
        }
    }

}
