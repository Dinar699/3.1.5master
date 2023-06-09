package com.example.spring_security.repositories;

import com.example.spring_security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u join fetch u.roles where u.email=:email")
    Optional<User> findUsersByEmail(String email);
}
