package com.email.in.repository;

import com.email.in.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getFindByUsername(String username);

}
