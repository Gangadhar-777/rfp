package com.my3tech.user.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.my3tech.user.dto.UserProfileDTO;
import com.my3tech.user.entity.UserProfile;
import com.my3tech.user.security.RegistrationRequest;

@Mapper(componentModel = "spring")
public interface UserprofileMapper {
    @Mapping(source = "uuid", target = "id")
    UserProfileDTO profileToProfileDTO(UserProfile profile);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(source = "id", target = "uuid")
    UserProfile profileDTOtoProfile(UserProfileDTO dto);
    
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "user", ignore = true)
    UserProfile toUserProfile(RegistrationRequest request);

    List<UserProfile> profileDTOtoProfileList(List<UserProfileDTO> dtos);

    List<UserProfileDTO> profileToProfileDTOList(List<UserProfile> profiles);
}
