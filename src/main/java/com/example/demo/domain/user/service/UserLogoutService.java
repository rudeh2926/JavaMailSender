package com.example.demo.domain.user.service;

import com.example.demo.domain.user.domain.User;
import com.example.demo.domain.user.exception.EmailNotFoundException;
import com.example.demo.domain.user.facade.UserFacade;
import com.example.demo.global.security.jwt.entity.RefreshToken;
import com.example.demo.global.security.jwt.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLogoutService {

    private final UserFacade userFacade;
    private final RefreshTokenRepository refreshTokenRepository;

    public void logout() {
        User user = userFacade.getCurrentUser();
        RefreshToken refreshToken = refreshTokenRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> EmailNotFoundException.EXCEPTION);

        refreshTokenRepository.delete(refreshToken);
    }
}
