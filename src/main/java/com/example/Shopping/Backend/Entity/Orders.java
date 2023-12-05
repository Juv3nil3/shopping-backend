package com.example.Shopping.Backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String orderName;

    @ManyToOne
    Users users;

    Date estimateDelivery;

    int totalOrderPrice;

    @OneToMany
    List<Product> orderItems;

    boolean isDelivered;

    int totalOrderItems;
}
