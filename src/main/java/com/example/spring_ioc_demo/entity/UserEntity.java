package com.example.spring_ioc_demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="wallet")

@NoArgsConstructor
@AllArgsConstructor

@Data
public class UserEntity {

    @Id


    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="balance")
    private long balance;



}
