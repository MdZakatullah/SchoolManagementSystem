package com.zak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zak.entity.User;
import com.zak.repository.UsersRepository;

import java.util.UUID;

@Service
public class PasswordResetService {
    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private EmailService emailService;

    public void initiatePasswordReset(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        String token = UUID.randomUUID().toString();
        user.setResetToken(token);
        userRepository.save(user);

        emailService.sendResetPasswordEmail(email, token);
    }

    public void resetPassword(String token, String newPassword) {
        User user = userRepository.findByResetToken(token);
        if (user == null) {
            throw new RuntimeException("Invalid token");
        }

        user.setPassword(newPassword); // Ideally, encrypt the password here
        user.setResetToken(null);
        userRepository.save(user);
    }
}
