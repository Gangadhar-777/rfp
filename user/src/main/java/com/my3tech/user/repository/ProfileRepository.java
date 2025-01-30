package com.my3tech.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my3tech.user.entity.User;
import com.my3tech.user.entity.UserProfile;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<UserProfile, Long> {
    Optional<UserProfile> findByUser(User user);
}
