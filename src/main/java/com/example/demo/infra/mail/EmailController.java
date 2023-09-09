package com.example.demo.infra.mail;

import com.example.demo.infra.mail.Service.ResendCodeRequestService;
import com.example.demo.infra.mail.Service.CreateEmailCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("email/code")
@RequiredArgsConstructor
public class EmailController {

    private final ResendCodeRequestService resendCodeRequestService;
    private final CreateEmailCodeService createEmailCodeServicce;

    @PostMapping
    public String requestEmailCode(String email) {
        return createEmailCodeServicce.sendVerificationCode(email);
    }

    @PostMapping("/resend")
    public void resendEmailCode(String email) {
        resendCodeRequestService.ResendCode(email);
    }
}
