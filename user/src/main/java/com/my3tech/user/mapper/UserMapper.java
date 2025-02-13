package com.my3tech.user.mapper;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.my3tech.user.dto.UserDTO;
import com.my3tech.user.entity.Roles;
import com.my3tech.user.entity.User;
import com.my3tech.user.security.RegistrationRequest;

@Mapper(componentModel = "spring", uses = { UserprofileMapper.class, RolesMapper.class })
public interface UserMapper {

    @Mapping(source = "roles", target = "roles", qualifiedByName = "rolesToString")
    @Mapping(source = "userProfile", target = "profileDTO")
    @Mapping(source = "uuid", target = "id")
    UserDTO userToUserDTO(User user);

    @Mapping(source = "roles", target = "roles", qualifiedByName = "stringToRoles")
    @Mapping(source = "id", target = "uuid")
    @Mapping(target= "createdAt", ignore = true)
    @Mapping(target= "updatedAt", ignore = true)
    @Mapping(target= "isActive", ignore = true)
    @Mapping(target= "isLocked", ignore = true)
    @Mapping(target= "password", ignore = true)
    @Mapping(source = "profileDTO", target = "userProfile")
    User userDTOtoUser(UserDTO dto);

    @Mapping(target= "createdAt", ignore = true)
    @Mapping(target= "updatedAt", ignore = true)
    @Mapping(target= "isActive", ignore = true)
    @Mapping(target= "id", ignore= true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "isLocked", ignore = true)
    @Mapping(target = "userProfile", ignore = true)
    User toUser(RegistrationRequest request);


    // Converts Set<Roles> to a comma-separated String
    @Named("rolesToString")
    static String rolesToString(Set<Roles> roles) {
        return roles != null ? roles.stream().map(Roles::getRoleName).collect(Collectors.joining(",")) : "";
    }

    // Converts a comma-separated String to Set<Roles>
    @Named("stringToRoles")
    static Set<Roles> stringToRoles(String roles) {
        return roles != null && !roles.isEmpty()
                ? Arrays.stream(roles.split(",")).map(Roles::new).collect(Collectors.toSet())
                : Set.of();
    }
}
