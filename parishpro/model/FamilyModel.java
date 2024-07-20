package com.newwayus.parishpro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamilyModel {

    private String familyId;
    private String familyName;
    private String registeredDate;
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

    private String status;
//    private Set<MemberModel> memberModels; // Collection o
//    private Set<String> anbiyamIds; // Collection of Anbiyam IDs

}
