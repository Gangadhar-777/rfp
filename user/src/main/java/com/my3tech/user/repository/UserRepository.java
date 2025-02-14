package com.my3tech.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my3tech.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}   
