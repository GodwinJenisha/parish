package com.newwayus.parishpro.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressModel {

    private String addressId;

    private String address1;

    private String address2;

    private String city;

    private String district;

    private String state;

    private String postalCode;

    private String country;

}