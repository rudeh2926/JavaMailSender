package com.example.demo.domain.user.service;

import com.example.demo.domain.user.domain.User;
import com.example.demo.domain.user.domain.repository.UserRepository;
import com.example.demo.domain.user.exception.*;
import com.example.demo.domain.user.presentation.dto.request.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final StringRedisTemplate stringRedisTemplate;

    @Transactional
    public void signup(SignupRequest request) {

        if (userRepository.existsByNickname(request.getNickname()) || userRepository.existsByEmail(request.getEmail())) {
            throw NicknameOrEmailAlreadyExistsException.EXCEPTION;
        }

        if (!request.getPassword().equals(request.getPasswordValid())) {
            throw PasswordMissMatchException.EXCEPTION;
        }

        if (!request.getEmailCodeValid().equals(stringRedisTemplate.opsForValue().get(request.getEmail()))) {
            throw EmailCodeOrEmailMissMatchException.EXCEPTION;
        }

        userRepository.save(
                User.builder()
                        .email(request.getEmail())
                        .nickname(request.getNickname())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .gender(request.getGender())
                        .build());
    }

}
