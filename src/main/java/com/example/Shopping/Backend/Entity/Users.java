package com.example.Shopping.Backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int uid;

    @Column(unique = true)
    String userName;

    String password;

    String role;

    String address;

    @Column(unique = true)
    String email;

    @Column(length=10, unique = true)
    Long phoneNumber;

    boolean isAdminApproved;
}
