package com.example.demo.domain.user.service;

import com.example.demo.domain.user.domain.User;
import com.example.demo.domain.user.domain.repository.UserRepository;
import com.example.demo.domain.user.exception.*;
import com.example.demo.domain.user.presentation.dto.request.UserSignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserSignupService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final StringRedisTemplate stringRedisTemplate;

    @Transactional
    public void signup(UserSignupRequest userSignupRequest) {

        if (userRepository.existsByNickname(userSignupRequest.getNickname()) || userRepository.existsByEmail(userSignupRequest.getEmail())) {
            throw NicknameOrEmailAlreadyExistsException.EXCEPTION;
        }

        if (!userSignupRequest.getPassword().equals(userSignupRequest.getPasswordValid())) {
            throw PasswordMissMatchException.EXCEPTION;
        }

        if (!userSignupRequest.getEmailCodeValid().equals(stringRedisTemplate.opsForValue().get(userSignupRequest.getEmail()))) {
            throw EmailCodeOrEmailMissMatchException.EXCEPTION;
        }

        userRepository.save(
                User.builder()
                        .email(userSignupRequest.getEmail())
                        .nickname(userSignupRequest.getNickname())
                        .password(passwordEncoder.encode(userSignupRequest.getPassword()))
                        .gender(userSignupRequest.getGender())
                        .build());
    }

}
