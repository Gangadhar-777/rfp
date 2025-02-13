package com.my3tech.user.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserDTO {
    private String id;
    private String username;
    private String email;

    private UserProfileDTO profileDTO;
    private String roles;
}
