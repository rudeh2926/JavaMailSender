package com.example.demo.infra.mail.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResendCodeRequestService {

    private final StringRedisTemplate stringRedisTemplate;
    private final CreateEmailCodeService createEmailCodeService;

    public String ResendCode(String email) {
        stringRedisTemplate.delete(email);
        return createEmailCodeService.sendVerificationCode(email);
    }
}
