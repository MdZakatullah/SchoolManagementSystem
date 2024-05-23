package com.zak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zak.service.PasswordResetService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private PasswordResetService passwordResetService;

    @PostMapping("/forgot-password")
    public void forgotPassword(@RequestParam String email) {
        passwordResetService.initiatePasswordReset(email);
    }

    @PostMapping("/reset-password")
    public void resetPassword(@RequestParam String token, @RequestParam String newPassword) {
        passwordResetService.resetPassword(token, newPassword);
    }
}

