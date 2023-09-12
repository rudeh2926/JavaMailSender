package com.example.demo.domain.user.service;

import com.example.demo.domain.user.domain.User;
import com.example.demo.domain.user.exception.EmailCodeOrEmailMissMatchException;
import com.example.demo.domain.user.exception.PasswordMissMatchException;
import com.example.demo.domain.user.facade.UserFacade;
import com.example.demo.domain.user.presentation.dto.request.UpdatePasswordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdatePasswordService {

    private final PasswordEncoder passwordEncoder;
    private final UserFacade userFacade;
    private final StringRedisTemplate redisTemplate;

    @Transactional
    public void updatePassword(UpdatePasswordRequest updatePasswordRequest) {

        User user = userFacade.getUserByEmail(updatePasswordRequest.getEmail());

        if (updatePasswordRequest.getEmailCode().equals(redisTemplate.opsForValue().get(updatePasswordRequest.getEmail()))) {
            throw EmailCodeOrEmailMissMatchException.EXCEPTION;
        }

        if (updatePasswordRequest.getPassword().equals(updatePasswordRequest.getPasswordValid())) {
            throw PasswordMissMatchException.EXCEPTION;
        }

        user.modifyPassword(passwordEncoder.encode(updatePasswordRequest.getPassword()));

    }
}
