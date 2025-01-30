package com.my3tech.user.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Roles extends BaseEntity {
    private String roleName;
}
