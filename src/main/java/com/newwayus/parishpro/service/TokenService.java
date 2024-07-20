package com.newwayus.parishpro.service;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public void deleteToken(String token) {
        // Perform token deletion logic here (e.g., blacklist the token)
        // For demonstration purposes, let's assume the token is invalidated
        System.out.println("Token deleted: " + token);
    }
}
