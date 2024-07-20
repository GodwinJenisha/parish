package com.newwayus.parishpro.model;

import java.util.Date;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriestModel {

    private String priestId;
    private String name;
    private String dateOfBirth;
    private String ordinationDate;
    private String contactNumber;
    private String email;
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

    private String startDate;
    private String endDate;
    private String status;
    private Set<String> parishIds; // Collection of Parish IDs
}
