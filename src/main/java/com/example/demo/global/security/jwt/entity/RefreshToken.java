package com.example.demo.global.security.jwt.entity;

import lombok.*;
import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@Getter
@AllArgsConstructor
@Builder
@RedisHash
public class RefreshToken {

    @Id
    private String email;

    private String refreshToken;

    private Long refreshTokenTime;

}