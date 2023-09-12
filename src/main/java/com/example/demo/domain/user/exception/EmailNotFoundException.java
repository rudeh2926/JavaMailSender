package com.example.demo.domain.user.exception;

import com.example.demo.global.error.exception.BusinessException;
import com.example.demo.global.error.exception.ErrorCode;

public class EmailNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new EmailNotFoundException();

    private EmailNotFoundException(){
        super(ErrorCode.EMAIL_NOT_FOUND);
    }

}
