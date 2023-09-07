package com.example.demo.domain.user.exception;

import com.example.demo.global.error.exception.BusinessException;
import com.example.demo.global.error.exception.ErrorCode;

public class NicknameOrEmailAlreadyExistsException extends BusinessException {
    public static final BusinessException EXCEPTION = new NicknameOrEmailAlreadyExistsException();

    private NicknameOrEmailAlreadyExistsException(){
        super(ErrorCode.NICKNAME_OR_EMAIL_ALREADY_EXISTS);
    }
}