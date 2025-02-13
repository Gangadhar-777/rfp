package com.my3tech.user.service.impl;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.my3tech.user.dto.UserDTO;
import com.my3tech.user.entity.Roles;
import com.my3tech.user.entity.User;
import com.my3tech.user.entity.UserProfile;
import com.my3tech.user.exception.UserNotFoundException;
import com.my3tech.user.mapper.UserMapper;
import com.my3tech.user.mapper.UserprofileMapper;
import com.my3tech.user.repository.RoleRepository;
import com.my3tech.user.repository.UserRepository;
import com.my3tech.user.security.AuthenticationRequest;
import com.my3tech.user.security.RegistrationRequest;
import com.my3tech.user.service.IUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
        private final UserRepository userRepository;
        private final RoleRepository roleRepository;
        private final PasswordEncoder passwordEncoder;
        private final UserMapper userMapper;
        private final UserprofileMapper profileMapper;

        /*
         *
         */
        @Override
        public void loginUser(AuthenticationRequest authRequest) {
                User user = userRepository.findByEmail(authRequest.getEmail())
                                .orElseThrow(() -> new UserNotFoundException(
                                                "Invalid email " + authRequest.getEmail()));
                if (!passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
                        throw new RuntimeException("Wrong Password");
                }
        }

        @Override
        public UserDTO getUser(String email) {
                User user = userRepository.findByEmail(email)
                                .orElseThrow(() -> new UsernameNotFoundException(
                                                "User for email - " + email + " Doesn't exist!"));

                UserDTO userDTO = userMapper.userToUserDTO(user);
                System.out.println(userDTO);
                return userDTO;
        }

        @Override
        public UserDTO registerUser(RegistrationRequest request) {
                User user = userMapper.toUser(request);
                UserProfile profile = profileMapper.toUserProfile(request);
                user.setUserProfile(profile);
                profile.setUser(user);

                Roles role = roleRepository.findByRoleName("USER")
                                .orElseThrow(() -> new RuntimeException("Invalid role!"));

                user.addRole(role);
                User newUser = userRepository.save(user);

                UserDTO dto = userMapper.userToUserDTO(newUser);
                return dto;
        }

}
