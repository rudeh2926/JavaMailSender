package com.example.demo.domain.user.presentation.dto.request;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdatePasswordRequest {

    private String email;
    private String emailCode;
    private String newPassword;
    private String passwordValid;
}
