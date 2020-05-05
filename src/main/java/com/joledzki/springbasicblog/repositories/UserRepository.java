package com.joledzki.springbasicblog.repositories;

import com.joledzki.springbasicblog.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
