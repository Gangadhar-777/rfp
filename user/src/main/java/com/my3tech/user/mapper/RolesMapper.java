package com.my3tech.user.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.my3tech.user.dto.RoleDTO;
import com.my3tech.user.entity.Roles;

@Mapper(componentModel = "spring")
public interface RolesMapper {
    RoleDTO roleToRoleDTO(Roles role);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(source = "id", target = "uuid")
    Roles roleDTOtoRole(RoleDTO dto);
}
