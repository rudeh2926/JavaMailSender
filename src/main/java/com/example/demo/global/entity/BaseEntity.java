package com.example.demo.global.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
