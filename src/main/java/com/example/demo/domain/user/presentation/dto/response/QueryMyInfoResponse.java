package com.example.demo.domain.user.presentation.dto.response;

import com.example.demo.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QueryMyInfoResponse {

    private String nickname;

    public QueryMyInfoResponse(User user) {
        this.nickname = user.getNickname();
    }
}
