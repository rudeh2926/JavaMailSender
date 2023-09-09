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
    private final CreateEmailCodeService createEmailCodeService;

    @PostMapping
    public String requestEmailCode(@RequestParam String email) {
        return createEmailCodeService.sendVerificationCode(email);
    }

    @PostMapping("/resend")
    public void resendEmailCode(@RequestParam String email) {
        resendCodeRequestService.ResendCode(email);
    }
}
