package com.agrospace.agrospace.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agrospace.agrospace.Models.Role;
import com.agrospace.agrospace.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByEmail(String email);

    User findByRole(Role role);
}
