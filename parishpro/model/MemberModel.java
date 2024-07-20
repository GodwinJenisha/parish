package com.newwayus.parishpro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberModel {

    private String memberId;
    private String name;
    private String gender;
    private Date dateOfBirth;
    private Date baptismDate;
    private Date communionDate;
    private Date confirmationDate;
    private Date marriageDate;
    private Date deathDate;
    private String occupation;
    private String contactNumber;
    private String email;
    private Integer subscriptionYear;
    private String address1;
    private String address2;
    private String city;
    private String district;
    private String state;
    private String postalCode;
    private String country;
    private String comm_address1;
    private String comm_address2;
    private String comm_city;
    private String comm_district;
    private String comm_state;
    private String comm_postalCode;
    private String comm_country;
    private String father;
    private String mother;
    private String godFather;
    private String godMother;
    private String status;
//    private Set<String> associationIds; // Collection of Association IDs
//    private Set<String> familyIds; // Collection of Family IDs

}
