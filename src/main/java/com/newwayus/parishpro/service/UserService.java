package com.newwayus.parishpro.service;

import com.newwayus.parishpro.entity.UserEntity;
import com.newwayus.parishpro.model.UserModel;
import com.newwayus.parishpro.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Service;
import org.springframework.boot.ApplicationRunner;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Check if the user table is empty
        if (userRepository.count() == 0) {
            // Insert default user
            UserModel defaultUser = new UserModel();
            defaultUser.setUserName("admin");
            defaultUser.setPassword("admin");
            defaultUser.setPermissions("ME-TTT FA-TTT AN-TTT AS-TTT PA-TTT PR-TTT FE-TTT AU-TTT");
            defaultUser.setRole("Admin");

            createUser(defaultUser);
        }
    }

    public UserModel createUser(UserModel userModel) {
        UserEntity userEntity = modelMapper.map(userModel, UserEntity.class);
        userEntity = userRepository.save(userEntity);
        return modelMapper.map(userEntity, UserModel.class);
    }

    public List<UserModel> getAllUser() {
        return userRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, UserModel.class))
                .collect(Collectors.toList());
    }

    public UserModel getUserById(int userId) {
        return userRepository.findById(userId)
                .map(entity -> modelMapper.map(entity, UserModel.class))
                .orElse(null);
    }

    public UserModel updateUser(int userId, UserModel userModel) {
        UserEntity userEntity = modelMapper.map(userModel, UserEntity.class);
        userEntity.setUserId(userId);
        userEntity = userRepository.save(userEntity);
        return modelMapper.map(userEntity, UserModel.class);
    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    // New method for user authentication
    public boolean authenticateUser(String username, String password) {
        // Log the received username and password
        System.out.println("Received username: " + username);
        System.out.println("Received password: " + password);

        UserEntity userEntity = userRepository.findByUserName(username);
        if (userEntity != null) {
            // Log the user entity found in the database
            System.out.println("User found: " + userEntity);

            // Check if the provided password matches the user's password
            boolean passwordMatch = userEntity.getPassword().equals(password);
            System.out.println("Password match: " + passwordMatch);

            return passwordMatch;
        }
        System.out.println("User not found");
        return false; // User not found or password doesn't match
    }

    public String getUserRole(String username) {
        UserEntity userEntity = userRepository.findByUserName(username);
        if (userEntity != null) {
            return userEntity.getRole();
        }
        return null; // User not found or role not available
    }

    public String getUserPermissions(String username) {
        UserEntity userEntity = userRepository.findByUserName(username);
        if (userEntity != null) {
            return userEntity.getPermissions();
        }
        return null; // User not found or role not available
    }
}
