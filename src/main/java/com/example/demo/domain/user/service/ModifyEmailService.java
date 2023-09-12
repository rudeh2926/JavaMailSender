package com.example.demo.domain.user.service;

import com.example.demo.domain.user.domain.User;
import com.example.demo.domain.user.exception.EmailCodeOrEmailMissMatchException;
import com.example.demo.domain.user.exception.PasswordMissMatchException;
import com.example.demo.domain.user.facade.UserFacade;
import com.example.demo.domain.user.presentation.dto.request.ModifyEmailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ModifyEmailService {

    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;
    private final StringRedisTemplate redisTemplate;

    @Transactional
    public void modifyEmail(ModifyEmailRequest modifyEmailRequest) {

        User user = userFacade.getCurrentUser();

        if (modifyEmailRequest.getPassword().equals(user.getPassword())) {
            throw PasswordMissMatchException.EXCEPTION;
        }

        if (modifyEmailRequest.getEmailCode().equals(redisTemplate.opsForValue().get(modifyEmailRequest.getEmail()))) {
            throw EmailCodeOrEmailMissMatchException.EXCEPTION;
        }

        user.modifyEmail(modifyEmailRequest.getEmail());
    }
}
