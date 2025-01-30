package com.my3tech.user.service.impl;

import java.util.Set;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.my3tech.user.dto.RoleDTO;
import com.my3tech.user.dto.UserDTO;
import com.my3tech.user.dto.UserProfileDTO;
import com.my3tech.user.entity.Roles;
import com.my3tech.user.entity.User;
import com.my3tech.user.entity.UserProfile;
import com.my3tech.user.exception.UserNotFoundException;
import com.my3tech.user.repository.ProfileRepository;
import com.my3tech.user.repository.UserRepository;
import com.my3tech.user.security.AuthenticationRequest;
import com.my3tech.user.security.RegistrationRequest;
import com.my3tech.user.service.IUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final PasswordEncoder passwordEncoder;

    /*
     *
     */
    @Override
    public void loginUser(AuthenticationRequest authRequest) {
        User user = userRepository.findByEmail(authRequest.getEmail())
                .orElseThrow(() -> new UserNotFoundException("Invalid email " + authRequest.getEmail()));
        if (!passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Wrong Password");
        }
    }

    @Override
    public UserDTO getUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User for email - " + email + " Doesn't exist!"));

        UserProfile up = profileRepository.findByUser(user).get();
        Set<Roles> roles = user.getRoles();

        UserProfileDTO upDTO = UserProfileDTO
                .builder()
                .firstName(up.getFirstName())
                .lastName(up.getLastName())
                .gender(up.getGender())
                .address(up.getAddress())
                .bio(up.getBio())
                .dateOfBirth(up.getDateOfBirth())
                .phoneNumber(up.getPhoneNumber())
                .build();

        UserDTO uDTO = UserDTO
                .builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .profileDTO(upDTO)
                .build();
        uDTO.setRoleDTO(roles.stream().map(role -> new RoleDTO(role.getRoleName())).toList());

        return uDTO;
    }

    @Override
    public UserDTO registerUser(RegistrationRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());

        user = userRepository.save(user);

        UserProfile profile = new UserProfile();

        profile.setFirstName(request.getFirstName());
        profile.setLastName(request.getLastName());
        profile.setPhoneNumber(request.getPhoneNumber());
        profile.setAddress(request.getAddress());
        profile.setDateOfBirth(request.getDateOfBirth());
        profile.setGender(request.getGender());
        profile.setBio(request.getBio());

        profile.setUser(user);

        UserProfile pr = profileRepository.save(profile);
        Roles r = new Roles();
        r.setRoleName("USER");

        user.addRole(r);
        User finalUser = userRepository.save(user);

        RoleDTO rDto = RoleDTO.builder()
                .roleName(r.getRoleName())
                .build();

        UserProfileDTO upDTO = UserProfileDTO
                .builder()
                .firstName(pr.getFirstName())
                .lastName(pr.getLastName())
                .gender(pr.getGender())
                .address(pr.getAddress())
                .bio(pr.getBio())
                .dateOfBirth(pr.getDateOfBirth())
                .phoneNumber(pr.getPhoneNumber())
                .build();

        UserDTO userDTO = UserDTO
                .builder()
                .username(finalUser.getUsername())
                .email(finalUser.getEmail())
                .profileDTO(upDTO)
                .build();
        userDTO.addRole(rDto);

        return userDTO;
    }

}
