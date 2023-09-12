package com.example.demo.domain.user.service;

import com.example.demo.domain.user.domain.User;
import com.example.demo.domain.user.exception.PasswordMissMatchException;
import com.example.demo.domain.user.facade.UserFacade;
import com.example.demo.domain.user.presentation.dto.request.LoginRequest;
import com.example.demo.global.security.jwt.JwtProvider;
import com.example.demo.global.security.jwt.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLoginService {

    private final PasswordEncoder passwordEncoder;
    private final UserFacade userFacade;
    private final JwtProvider jwtProvider;

    public TokenResponse login(LoginRequest loginRequest) {

        User user = userFacade.getUserByEmail(loginRequest.getEmail());

        if (loginRequest.getPassword().equals(user.getPassword())) {
            throw PasswordMissMatchException.EXCEPTION;
        }
        return jwtProvider.getToken(user);
    }
}
