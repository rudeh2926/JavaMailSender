package com.example.demo.global.config;

import com.example.demo.global.security.jwt.JwtProvider;
import com.example.demo.global.security.jwt.JwtTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtProvider jwtProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/image/upload").authenticated()
                // 나머지 요청은 모든 사용자에게 허용합니다.
                // 주의: 이 부분을 실제 요구 사항에 맞게 수정해야 합니다.
                // 예: 인증된 사용자만 접근하도록 변경 등
                .anyRequest().permitAll()
                .and()
                // JwtTokenFilter를 UsernamePasswordAuthenticationFilter 앞에 추가합니다.
                .addFilterBefore(new JwtTokenFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class);
    }
}
