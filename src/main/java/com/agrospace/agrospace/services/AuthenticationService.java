package com.agrospace.agrospace.services;

import com.agrospace.agrospace.Models.User;
import com.agrospace.agrospace.dto.JwtAuthenticationResponse;
import com.agrospace.agrospace.dto.RefreshTokenRequest;
import com.agrospace.agrospace.dto.SignInRequest;
import com.agrospace.agrospace.dto.SignUpRequest;

public interface AuthenticationService {

    User signup(SignUpRequest signUpRequest);

    JwtAuthenticationResponse signin(SignInRequest signInRequest);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

}
