package com.example.demo.domain.user.service;

import com.example.demo.domain.user.domain.User;
import com.example.demo.domain.user.exception.PasswordMissMatchException;
import com.example.demo.domain.user.facade.UserFacade;
import com.example.demo.domain.user.presentation.dto.response.QueryDetaileMyInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QueryDetaileMyInfoService {

    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public QueryDetaileMyInfoResponse QueryDetaileInfo(String password) {

        User user = userFacade.getCurrentUser();

        if (password.equals(user.getPassword())) {
            throw PasswordMissMatchException.EXCEPTION;
        }

        return new QueryDetaileMyInfoResponse(user);
    }
}
