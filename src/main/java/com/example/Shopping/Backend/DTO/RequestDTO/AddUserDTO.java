package com.example.Shopping.Backend.DTO.RequestDTO;

import com.example.Shopping.Backend.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUserDTO {

    String userName;

    String password;

    String email;

    Long phoneNumber;

    String address;

    Role role;
}
