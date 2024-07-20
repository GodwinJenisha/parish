package com.newwayus.parishpro.controller;

import com.newwayus.parishpro.model.UserModel;
import com.newwayus.parishpro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
