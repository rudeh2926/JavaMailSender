package com.example.demo.domain.User.domain;

import com.example.demo.global.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class User extends BaseEntity {

    private String accountId;

    private String email;

    private String password;
}
