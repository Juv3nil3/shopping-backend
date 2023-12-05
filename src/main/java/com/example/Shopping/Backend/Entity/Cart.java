package com.example.Shopping.Backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int  cId;

    @OneToOne
    Users users;

    int totalPrice;

    int totalItems;

    @OneToMany
    List<Product> products;
}
