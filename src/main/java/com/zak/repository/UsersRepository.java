package com.zak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zak.entity.User;

public interface UsersRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByResetToken(String resetToken);
}

