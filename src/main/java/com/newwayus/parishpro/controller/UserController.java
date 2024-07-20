package com.newwayus.parishpro.controller;

import com.newwayus.parishpro.model.UserModel;
import com.newwayus.parishpro.service.TokenService;
import com.newwayus.parishpro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3030")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/add")
    public UserModel createUser(@RequestBody UserModel userModel){

        return  userService.createUser(userModel);
    }


    @GetMapping("/list")
    public List<UserModel> getAllUser(){

        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable int id){
        UserModel userModel = userService.getUserById(id);
        return  userModel != null ? ResponseEntity.ok(userModel) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable int id, @RequestBody UserModel updatedUser){
        UserModel updatedUsers = userService.updateUser(id, updatedUser);
        return updatedUsers != null ? ResponseEntity.ok(updatedUser): ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        // Call the authentication method in the UserService
        boolean isAuthenticated = userService.authenticateUser(username, password);

        if (isAuthenticated) {
            // Retrieve the user role
            String role = userService.getUserRole(username);
            String permissions = userService.getUserPermissions(username);
            // Generate a token (if needed)
            String token = generateToken(username);

            // Create a response object containing token and role
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("role", role);
            response.put("username", username);
            response.put("permissions", permissions);

            logger.info("Username included in response: {}", username);
            logger.info("permissions included in response: {}", permissions);

            // Return success response with token and role
            return ResponseEntity.ok(response);
        } else {
            // Return error response if authentication fails
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    private String generateToken(String username) {
        // You can use JWT or any other token-based authentication mechanism here
        // For demonstration purposes, let's just return a simple token with the username
        return "generated_token " + username; // Example: Bearer john_doe
    }

    @Autowired
    private TokenService tokenService;
    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody Map<String, String> requestData) {
        String token = requestData.get("token");

        // Call the token service to delete the token
        tokenService.deleteToken(token);

        return ResponseEntity.ok("Logout successful");
    }

}

