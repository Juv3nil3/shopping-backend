package com.example.Shopping.Backend.Service;

import com.example.Shopping.Backend.DTO.RequestDTO.AddProductDTO;
import com.example.Shopping.Backend.Entity.Product;
import com.example.Shopping.Backend.Exception.WrongAccessException;
import com.example.Shopping.Backend.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UsersService usersService;


    public void addProduct(AddProductDTO addProductDTO) {
        if(usersService.isAdmin(addProductDTO.getUserName())){
            Product product = new Product();
            product.setProductName(addProductDTO.getProductName());
            product.setCategory(addProductDTO.getCategory());
            product.setPrice(addProductDTO.getPrice());
            product.setDescription(addProductDTO.getDescription());
            product.setQuantity(addProductDTO.getQuantity());

            productRepository.save(product);
        } else {
            throw new WrongAccessException("User doesn't have admin access");
        }
    }
}
