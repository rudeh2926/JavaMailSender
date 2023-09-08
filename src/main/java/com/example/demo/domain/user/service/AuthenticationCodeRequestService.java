package com.example.demo.domain.user.service;

import com.example.demo.infra.mail.Service.SignupEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationCodeRequestService {

    private final SignupEmailService emailService;

    public void emailCode(String email) {
        emailService.sendVerificationCode(email);
    }
}
