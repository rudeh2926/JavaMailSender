package com.example.demo.domain.user.presentation;

import com.example.demo.domain.user.presentation.dto.request.SignupRequest;
import com.example.demo.domain.user.service.AuthenticationCodeRequestService;
import com.example.demo.domain.user.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final SignupService signupService;
    private final AuthenticationCodeRequestService service;

    @PostMapping
    public void signup(@RequestBody SignupRequest request) {
        signupService.signup(request);
    }

    @PostMapping("/email/code")
    public void emailCode(@RequestBody String email) {
        service.emailCode(email);
    }
}
