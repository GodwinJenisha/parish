package com.newwayus.parishpro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NonMemberModel {

    private String nonMemberId;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String email;
    private String address;


}
