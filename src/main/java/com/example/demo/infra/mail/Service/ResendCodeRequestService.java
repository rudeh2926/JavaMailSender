package com.example.demo.infra.mail.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResendCodeRequestService {

    private final StringRedisTemplate stringRedisTemplate;
    private final CreateEmailCodeService createEmailCodeServicce;

    public void ResendCode(String email) {
        stringRedisTemplate.delete(email);
        createEmailCodeServicce.sendVerificationCode(email);
    }
}
