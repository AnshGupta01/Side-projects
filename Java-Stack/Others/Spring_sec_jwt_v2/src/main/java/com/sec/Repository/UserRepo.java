package com.sec.Repository;

import com.sec.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, String> {
    public Optional<User> findByEmail(String email);
}
