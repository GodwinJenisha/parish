package com.newwayus.parishpro.service;

import com.newwayus.parishpro.entity.UserEntity;
import com.newwayus.parishpro.model.UserModel;
import com.newwayus.parishpro.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private ModelMapper modelMapper;

    public UserModel createUser(UserModel userModel){
        UserEntity userEntity =  modelMapper.map(userModel, UserEntity.class);
        userEntity = userRepository.save(userEntity);
        return modelMapper.map(userEntity, UserModel.class);
    }

    public List< UserModel> getAllUser() {
        return userRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity,  UserModel.class))
                .collect(Collectors.toList());
    }

    public  UserModel getUserById(int userId) {
        return userRepository.findById(userId)
                .map(entity -> modelMapper.map(entity,  UserModel.class))
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

}
