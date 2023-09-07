package com.example.demo.infra.mail.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import org.springframework.mail.SimpleMailMessage;

import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class SignupEmailService {

    private final JavaMailSender mailSender;
    private final StringRedisTemplate redisTemplate;

    public String generateVerificationCode() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder codeBuilder = new StringBuilder(6);

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(characters.length());
            codeBuilder.append(characters.charAt(index));
        }

        return codeBuilder.toString();
    }

    public String sendVerificationCode(String email) {
        String verificationCode = generateVerificationCode();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("회원 가입 인증 코드");
        message.setText("인증 코드: " + verificationCode);

        mailSender.send(message);

        redisTemplate.opsForValue().set(email, verificationCode, 180, TimeUnit.SECONDS);
        return verificationCode;
    }
}
