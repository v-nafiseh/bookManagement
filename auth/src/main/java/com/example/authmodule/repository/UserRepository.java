package com.example.authmodule.repository;

import com.example.authmodule.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
    @Query("SELECT u from Users u where u.id= :id")
    Users findUSerById(Long id);
}
