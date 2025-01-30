package com.my3tech.user.mapper;

import com.my3tech.user.dto.UserProfileDTO;
import com.my3tech.user.entity.UserProfile;

public class UserProfileMapper {
    public static UserProfile toUserProfile(UserProfileDTO userProfileDTO, UserProfile userProfile) {
        userProfile.setFirstName(userProfileDTO.getFirstName());
        userProfile.setLastName(userProfileDTO.getLastName());
        userProfile.setAddress(userProfileDTO.getAddress());
        userProfile.setDateOfBirth(userProfileDTO.getDateOfBirth());
        userProfile.setPhoneNumber(userProfileDTO.getPhoneNumber());
        userProfile.setBio(userProfileDTO.getBio());
        userProfile.setGender(userProfileDTO.getGender());
        return userProfile;
    }

    public static UserProfileDTO toUserProfileDTO(UserProfile userProfile, UserProfileDTO userProfileDTO) {
        userProfileDTO.setFirstName(userProfile.getFirstName());
        userProfileDTO.setLastName(userProfile.getLastName());
        userProfileDTO.setAddress(userProfile.getAddress());
        userProfileDTO.setDateOfBirth(userProfile.getDateOfBirth());
        userProfileDTO.setPhoneNumber(userProfile.getPhoneNumber());
        userProfileDTO.setBio(userProfile.getBio());
        userProfileDTO.setGender(userProfile.getGender());
        return userProfileDTO;
    }
}
