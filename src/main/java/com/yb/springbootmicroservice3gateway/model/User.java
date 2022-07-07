package com.yb.springbootmicroservice3gateway.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, nullable = false, length = 100)
    private String username;


    @Column(name = "password",nullable = false)
    private String password;


    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "creationTime")
    private LocalDateTime createdTime;

}
