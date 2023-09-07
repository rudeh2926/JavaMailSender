package com.example.demo.domain.user.exception;

import com.example.demo.global.error.exception.BusinessException;
import com.example.demo.global.error.exception.ErrorCode;

public class PasswordMissMatchException extends BusinessException {

    public static final BusinessException EXCEPTION = new PasswordMissMatchException();

    private PasswordMissMatchException(){
        super(ErrorCode.PASSWORD_MISS_MATCH);
    }

}