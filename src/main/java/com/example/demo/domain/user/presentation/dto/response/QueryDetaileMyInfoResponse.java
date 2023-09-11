package com.example.demo.domain.user.presentation.dto.response;

import com.example.demo.domain.user.domain.User;
import lombok.*;

@Getter
@AllArgsConstructor
public class QueryDetaileMyInfoResponse {

    private String email;
    private String password;
    private String nickname;

    public QueryDetaileMyInfoResponse(User user) {
        this.email = user.getEmail();
        this.nickname = user.getNickname();
        this.password = user.getPassword();
    }
}
