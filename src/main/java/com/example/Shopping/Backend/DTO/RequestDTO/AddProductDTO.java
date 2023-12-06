package com.example.Shopping.Backend.DTO.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddProductDTO {

    String productName;

    String category;

    String description;

    String quantity;

    String price;

    String userName;

}
