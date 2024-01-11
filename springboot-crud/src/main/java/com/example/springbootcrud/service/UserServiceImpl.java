package com.example.springbootcrud.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.springbootcrud.entity.User;
import com.example.springbootcrud.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        try {
            return userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateKeyException("User with the same key already exists", e);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create user", e);
        }
    }

    @Override
    public User getUserById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid user ID");
        }

        try {
            Optional<User> user = userRepository.findById(id);
            return user.orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve user by ID", e);
        }
    }

    @Override
    public User updateUserById(Long id, @Validated User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User originalUser = optionalUser.get();

            if (Objects.nonNull(updatedUser.getFirstName()) && !updatedUser.getFirstName().isEmpty()) {
                originalUser.setFirstName(updatedUser.getFirstName());
            }

            if (Objects.nonNull(updatedUser.getLastName()) && !updatedUser.getLastName().isEmpty()) {
                originalUser.setLastName(updatedUser.getLastName());
            }

            if (Objects.nonNull(updatedUser.getDateOfBirth())) {
                originalUser.setDateOfBirth(updatedUser.getDateOfBirth());
            }

            if (Objects.nonNull(updatedUser.getAddress()) && !updatedUser.getAddress().isEmpty()) {
                originalUser.setAddress(updatedUser.getAddress());
            }

            return userRepository.save(originalUser);
        }

        return null;
    }

    @Override
    public String deleteUserById(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return "User deleted successfully";
        }
        return "No such user in the database";
    }

}