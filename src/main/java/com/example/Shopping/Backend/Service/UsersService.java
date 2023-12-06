package com.example.Shopping.Backend.Service;

import com.example.Shopping.Backend.DTO.RequestDTO.AddUserDTO;
import com.example.Shopping.Backend.DTO.RequestDTO.LoginRequestDTO;
import com.example.Shopping.Backend.DTO.ResponseDTO.LoginResponseDTO;
import com.example.Shopping.Backend.Entity.Users;
import com.example.Shopping.Backend.Exception.UserNotFoundException;
import com.example.Shopping.Backend.Exception.WrongCredentialException;
import com.example.Shopping.Backend.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public Users signUp(AddUserDTO userDTO) {
        String role = userDTO.getRole().toString();

        Users user = new Users();

        user.setUserName(userDTO.getUserName());
        user.setAddress(userDTO.getAddress());
        user.setRole(userDTO.getRole().toString());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setAdminApproved(false);

        usersRepository.save(user);

        return user;

    }

    public LoginResponseDTO logIn(LoginRequestDTO loginRequestDTO) {
        String userName = loginRequestDTO.getUserName();
        Users user = usersRepository.findByUserName(userName);

        if(user != null) {
            if(user.getPassword().equals(loginRequestDTO.getPassword())) {
                return new LoginResponseDTO("Success");
            }
            else {
                throw new WrongCredentialException("user password is wrong!!");
            }

        } else {
            throw  new UserNotFoundException("The following user does not exist in our system");
        }
    }

    public boolean isAdmin(String userName) {
        Users user = usersRepository.findByUserName(userName);
        if(user == null) {
            throw new UserNotFoundException("The following user does not exists");
        }
        if(user.isAdminApproved() == true) {
            return true;
        }
        return false;
    }
}
