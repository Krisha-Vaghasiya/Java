package com.example.HospitalManagement.service;

import com.example.HospitalManagement.dto.LoginRequestDto;
import com.example.HospitalManagement.dto.LoginResponseDto;
import com.example.HospitalManagement.dto.SignUpResponseDto;
import com.example.HospitalManagement.entity.User;
import com.example.HospitalManagement.repository.UserRepository;
import com.example.HospitalManagement.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;


    public SignUpResponseDto signup(LoginRequestDto signupRequestDto) {
        User user = userRepository.save(User.builder()
                .username(signupRequestDto.getUsername())
                .password(passwordEncoder.encode(signupRequestDto.getPassword())
                ).build());
        return new SignUpResponseDto(user.getUsername(), user.getId());
    }

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword())
        );

        User user = (User) authentication.getPrincipal();

        String token = jwtUtils.getJwtToken(user);

        return new LoginResponseDto(token, user.getId());
    }
}
