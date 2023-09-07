package com.example.demo.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {


    USER_NOT_FOUND(404, "User Not Found"),
    NICKNAME_OR_EMAIL_ALREADY_EXISTS(409, "Nickname Or EMAIL Already Exists"),
    PASSWORD_MISS_MATCH(400, "Password Miss Match"),
    EMAILCODE_MISS_MATCH(400, "EmailCode Miss Match"),

    JWT_EXPIRED(401, "Jwt Expired"),
    JWT_INVALID(401, "Jwt Invalid"),

    BAD_REQUEST(400, "Bad request"),
    INTERNAL_SERVER_ERROR(500, "Internal server error");

    private final Integer statusCode;
    private final String message;
}
