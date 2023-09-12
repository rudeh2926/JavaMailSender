package com.example.demo.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ModifyEmailRequest {

    private String email;
    private String emailCode;
    private String password;
}
