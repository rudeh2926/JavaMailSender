package com.example.demo.domain.user.presentation;


import com.example.demo.domain.user.domain.repository.UserRepository;
import com.example.demo.domain.user.presentation.dto.request.SignupRequest;
import com.example.demo.domain.user.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final SignupService signupService;

    @PostMapping
    public void signup(SignupRequest request) {
        signupService.signup(request);
    }
}
