package com.example.demo.global.security.jwt.repository;

import com.example.demo.global.security.jwt.entity.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, Long> {
    boolean existsByEmail(String email);
}