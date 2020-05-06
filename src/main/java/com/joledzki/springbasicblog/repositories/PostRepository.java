package com.joledzki.springbasicblog.repositories;

import com.joledzki.springbasicblog.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Override
    List<Post> findAll();
}
