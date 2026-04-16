package com.example.bookingSystem.service;

import com.example.bookingSystem.model.Users;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<Users> getAllUsers();
    Users saveUser(Users user);
    Optional<Users> findByEmail(String email);
}
