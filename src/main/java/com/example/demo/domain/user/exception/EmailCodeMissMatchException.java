package com.example.demo.domain.user.exception;

import com.example.demo.global.error.exception.BusinessException;
import com.example.demo.global.error.exception.ErrorCode;

public class EmailCodeMissMatchException extends BusinessException {
    public static final BusinessException EXCEPTION = new EmailCodeMissMatchException();

    private EmailCodeMissMatchException(){
        super(ErrorCode.EMAILCODE_MISS_MATCH);
    }
}
