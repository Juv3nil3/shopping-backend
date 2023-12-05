package com.example.Shopping.Backend.Controller;

import com.example.Shopping.Backend.DTO.RequestDTO.AddUserDTO;
import com.example.Shopping.Backend.DTO.RequestDTO.LoginRequestDTO;
import com.example.Shopping.Backend.DTO.ResponseDTO.LoginResponseDTO;
import com.example.Shopping.Backend.Entity.Users;
import com.example.Shopping.Backend.Exception.UserNotFoundException;
import com.example.Shopping.Backend.Exception.WrongCredentialException;
import com.example.Shopping.Backend.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    UsersService usersService;

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody AddUserDTO addUserDTO) {
        Users user = usersService.signUp(addUserDTO);

        return new ResponseEntity(user, HttpStatus.CREATED);
    }

    @GetMapping ("/login")
    public ResponseEntity logIn(@RequestBody LoginRequestDTO loginRequestDTO) {
        try {
            LoginResponseDTO loginResponseDTO = usersService.logIn(loginRequestDTO);
            return new ResponseEntity(loginResponseDTO, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (WrongCredentialException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}
