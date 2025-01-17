package com.newwayus.parishpro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    private int userId;
    private String userName;
    private String password;
    private String role;
    private String permissions;

}
