package com.IULP.BackEnd.Repository;

import com.IULP.BackEnd.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository {
    Optional<User> findByUsername(String username);
}
