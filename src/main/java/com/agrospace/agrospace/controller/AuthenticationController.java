package com.agrospace.agrospace.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agrospace.agrospace.Models.Student;
import com.agrospace.agrospace.Models.User;
import com.agrospace.agrospace.dto.JwtAuthenticationResponse;
import com.agrospace.agrospace.dto.RefreshTokenRequest;
import com.agrospace.agrospace.dto.SignInRequest;
import com.agrospace.agrospace.dto.SignUpRequest;
import com.agrospace.agrospace.services.AuthenticationService;
import com.agrospace.agrospace.services.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    private final StudentService studentService;

    @PostMapping("/signup")
    ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(authenticationService.signin(signInRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }

    @PostMapping("/create")
    public ResponseEntity<Student> create(@RequestBody Student studentR){
        return ResponseEntity.ok(studentService.createStudent(studentR));
    }

}
