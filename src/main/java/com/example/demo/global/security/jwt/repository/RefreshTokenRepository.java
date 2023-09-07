package com.example.demo.global.security.jwt.repository;

import com.example.demo.global.security.jwt.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    boolean existsByEmail(String email);
}