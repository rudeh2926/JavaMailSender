package com.example.demo.global.security.jwt.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Builder
@RedisHash
public class RefreshToken {

    @Id
    private String email;

    private String refreshToken;

    private Long refreshTokenTime;

}