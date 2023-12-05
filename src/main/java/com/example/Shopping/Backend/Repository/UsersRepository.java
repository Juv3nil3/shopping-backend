package com.example.Shopping.Backend.Repository;

import com.example.Shopping.Backend.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    public Users findByUserName(String userName);
}
