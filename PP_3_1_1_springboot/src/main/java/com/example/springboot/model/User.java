package com.example.springboot.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users_table")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_age")
    private byte userAge;

    public User(String userName, String userEmail, byte userAge) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAge = userAge;
    }
}