package com.example.springbootcrud.service;

import com.example.springbootcrud.entity.User;

public interface UserService {
    User createUser(User employee);

    User getUserById(Long id);

    User updateUserById(Long id, User employee);

    String deleteUserById(Long id);
    
}
