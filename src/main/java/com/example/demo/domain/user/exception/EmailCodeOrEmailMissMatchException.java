package com.example.demo.domain.user.exception;

import com.example.demo.global.error.exception.BusinessException;
import com.example.demo.global.error.exception.ErrorCode;

public class EmailCodeOrEmailMissMatchException extends BusinessException {
    public static final BusinessException EXCEPTION = new EmailCodeOrEmailMissMatchException();

    private EmailCodeOrEmailMissMatchException(){
        super(ErrorCode.EMAILCODE_OR_EMAIL_MISS_MATCH);
    }
}
