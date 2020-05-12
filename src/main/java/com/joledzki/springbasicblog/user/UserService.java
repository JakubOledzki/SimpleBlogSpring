package com.joledzki.springbasicblog.user;

import com.joledzki.springbasicblog.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean checkUserDetails(){
       return SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails;
    }

    public User getUserDetails(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        boolean userDetails = userRepository.findByUsername(username).isPresent();
        if(!userDetails){
            throw new UsernameNotFoundException("Invalid User");
        }
        else{
            return userRepository.findByUsername(username).get();
        }
    }
}
