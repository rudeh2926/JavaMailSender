package com.example.demo.domain.user.presentation;

import com.example.demo.domain.user.presentation.dto.request.UserSignupRequest;
import com.example.demo.domain.user.service.UserSignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserSignupService userSignupService;

    @PostMapping
    public void signup(@RequestBody UserSignupRequest request) {
        userSignupService.signup(request);
    }
}