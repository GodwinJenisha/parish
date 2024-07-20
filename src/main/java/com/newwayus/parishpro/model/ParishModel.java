package com.newwayus.parishpro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParishModel {

    private String parishId;
    private String name;
    private String address1;
    private String address2;
    private String city;
    private String district;
    private String state;
    private String postalCode;
    private String country;
    private String switchValue;

    private String comm_address1;
    private String comm_address2;
    private String comm_city;
    private String comm_district;
    private String comm_state;
    private String comm_postalCode;
    private String comm_country;

    private String contactNumber;
    private String email;
    private String website;
    private String diocese;
    private char status;


}