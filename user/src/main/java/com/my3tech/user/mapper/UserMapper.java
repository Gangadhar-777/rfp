package com.my3tech.user.mapper;

import com.my3tech.user.dto.UserDTO;
import com.my3tech.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserMapper {  
    public static User toUser(UserDTO userDTO, User user) {
        user.setUsername(user.getUsername());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        return user;
    }

    public static UserDTO toUserDTO(User user, UserDTO userDTO) {
        return userDTO;
    }
}
