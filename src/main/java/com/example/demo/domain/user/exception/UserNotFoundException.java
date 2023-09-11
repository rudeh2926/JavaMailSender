package com.example.demo.domain.user.exception;

import com.example.demo.global.error.exception.BusinessException;
import com.example.demo.global.error.exception.ErrorCode;

public class UserNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException(){
        super(ErrorCode.USER_NOT_FOUND);
    }

}
