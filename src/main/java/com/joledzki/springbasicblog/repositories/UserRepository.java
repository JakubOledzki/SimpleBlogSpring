package com.joledzki.springbasicblog.repositories;

import com.joledzki.springbasicblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
