package com.example.demo.global.security.jwt.repository;

import com.example.demo.global.security.jwt.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    boolean existsByEmail(String email);
    Optional<RefreshToken> findByEmail(String email);
}