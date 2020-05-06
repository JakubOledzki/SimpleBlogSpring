package com.joledzki.springbasicblog.repositories;

import com.joledzki.springbasicblog.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
