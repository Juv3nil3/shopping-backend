package com.example.Shopping.Backend.Controller;

import com.example.Shopping.Backend.DTO.RequestDTO.AddProductDTO;
import com.example.Shopping.Backend.DTO.ResponseDTO.GeneralMessageDTO;
import com.example.Shopping.Backend.DTO.ResponseDTO.UnAuthorized;
import com.example.Shopping.Backend.Exception.UserNotFoundException;
import com.example.Shopping.Backend.Exception.WrongAccessException;
import com.example.Shopping.Backend.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    ProductService productService;

    @PostMapping("/product/add")
    public ResponseEntity addProduct(AddProductDTO addProductDTO) {

        try{
            productService.addProduct(addProductDTO);
            return new ResponseEntity(new GeneralMessageDTO("Product Successfully got added"), HttpStatus.CREATED);
        } catch (WrongAccessException e){
            return new ResponseEntity(new UnAuthorized(e.getMessage()), HttpStatus.UNAUTHORIZED);
        } catch (UserNotFoundException e){
            return new ResponseEntity(new GeneralMessageDTO(e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
}
