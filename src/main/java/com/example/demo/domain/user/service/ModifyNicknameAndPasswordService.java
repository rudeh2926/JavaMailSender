package com.example.demo.domain.user.service;

import com.example.demo.domain.user.domain.User;
import com.example.demo.domain.user.exception.PasswordMissMatchException;
import com.example.demo.domain.user.facade.UserFacade;
import com.example.demo.domain.user.presentation.dto.request.ModifyNicknameAndPasswordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ModifyNicknameAndPasswordService {

    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void modifyNicknameAndPassword (ModifyNicknameAndPasswordRequest request) {

        User user = userFacade.getCurrentUser();

        if (request.getPassword().equals(user.getPassword())) {
            throw PasswordMissMatchException.EXCEPTION;
        }

        user.modifyNicknameAndPassword(request.getNickname(), passwordEncoder.encode(request.getPassword()));
    }
}
