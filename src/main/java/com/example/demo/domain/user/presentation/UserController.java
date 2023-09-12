package com.example.demo.domain.user.presentation;

import com.example.demo.domain.user.presentation.dto.request.*;
import com.example.demo.domain.user.presentation.dto.response.QueryDetaileMyInfoResponse;
import com.example.demo.domain.user.presentation.dto.response.QueryMyInfoResponse;
import com.example.demo.domain.user.service.*;
import com.example.demo.global.security.jwt.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserSignupService userSignupService;
    private final ModifyNicknameAndPasswordService modifyNicknameAndPasswordService;
    private final ModifyEmailService modifyEmailService;
    private final UpdatePasswordService updatePasswordService;
    private final QueryDetaileMyInfoService queryDetaileMyInfoService;
    private final QueryMyInfoService queryMyInfoService;
    private final UserLoginService userLoginService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void signup(@RequestBody UserSignupRequest request) {
        userSignupService.signup(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest loginRequest) {
        return userLoginService.login(loginRequest);
    }

    @PatchMapping("/modify")
    public void modifyNicknameAndPassword(@RequestBody ModifyNicknameAndPasswordRequest modifyNicknameAndPasswordRequest) {
        modifyNicknameAndPasswordService.modifyNicknameAndPassword(modifyNicknameAndPasswordRequest);
    }

    @PatchMapping("/email/modify")
    public void modifyEmail(@RequestBody ModifyEmailRequest modifyEmailRequest) {
        modifyEmailService.modifyEmail(modifyEmailRequest);
    }

    @PatchMapping("/update/password")
    public void updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest) {
        updatePasswordService.updatePassword(updatePasswordRequest);
    }

    @GetMapping("/detaile/info")
    public QueryDetaileMyInfoResponse queryDetaileMyInfo(@RequestParam String password) {
        return queryDetaileMyInfoService.QueryDetaileInfo(password);
    }

    @GetMapping("/info")
    public QueryMyInfoResponse queryMyInfo() {
       return queryMyInfoService.queryMyInfo();
    }
}