package com.example.springbootcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootcrud.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    
}
