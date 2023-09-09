package com.example.demo.domain.user.presentation;

import com.example.demo.domain.user.presentation.dto.request.SignupRequest;
import com.example.demo.domain.user.service.SignupService;
import com.example.demo.infra.mail.Service.ResendCodeRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final SignupService signupService;
    private final ResendCodeRequestService resendCodeRequestService;

    @PostMapping
    public void signup(@RequestBody SignupRequest request) {
        signupService.signup(request);
    }

    @PostMapping("code/Resend")
    public void resendCode(String email) {
        resendCodeRequestService.ResendCode(email);
    }

    @PostMapping("/email")
}