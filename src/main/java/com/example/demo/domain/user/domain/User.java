package com.example.demo.domain.user.domain;

import com.example.demo.domain.user.enums.Gender;
import com.example.demo.global.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class User extends BaseEntity {

    private String nickname;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    public void modifyEmail(String email) {
        this.email = email;
    }

    public void  modifyNicknameAndPassword(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }

    public void modifyPassword(String password) {
        this.password = password;
    }
}
