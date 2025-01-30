package com.my3tech.user.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserDTO {
    private String username;
    private String email;

    private UserProfileDTO profileDTO;
    private List<RoleDTO> roleDTO;

    public void addRole(RoleDTO dto) {
        if (roleDTO == null) {
            roleDTO = new ArrayList<>();
        }
        roleDTO.add(dto);
    }
}
