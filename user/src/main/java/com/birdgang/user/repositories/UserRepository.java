package com.birdgang.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.birdgang.user.Models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
}
