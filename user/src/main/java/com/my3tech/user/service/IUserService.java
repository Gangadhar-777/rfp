package com.my3tech.user.service;

import com.my3tech.user.dto.UserDTO;
import com.my3tech.user.security.AuthenticationRequest;
import com.my3tech.user.security.RegistrationRequest;

public interface IUserService {
   void loginUser(AuthenticationRequest authRequest);
   UserDTO getUser(String email);
   UserDTO registerUser(RegistrationRequest request);
}
