package com.my3tech.user.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    private String username;

    @Column(unique = true)
    private String email;
    private String password;
    private Boolean isActive = true;
    private Boolean isLocked = false;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<Roles> roles;

    public void addRole(Roles role) {
        if (roles == null || roles.isEmpty()) {
            roles = new HashSet<>();
        }
        roles.add(role);
    }
}
