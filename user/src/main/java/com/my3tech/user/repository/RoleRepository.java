package com.my3tech.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my3tech.user.entity.Roles;

public interface RoleRepository extends JpaRepository<Roles, Long> {

}
