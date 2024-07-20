package com.newwayus.parishpro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class AddressEntity {

    @Id
    @Column(name = "address_id", length = 10)
    private String addressId;

    @Column(name = "address1", length = 255, nullable = false)
    private String address1;

    @Column(name = "address2", length = 255, nullable = false)
    private String address2;

    @Column(name = "city", length = 255, nullable = false)
    private String city;

    @Column(name = "district", length = 255, nullable = false)
    private String district;

    @Column(name = "state", length = 255, nullable = false)
    private String state;

    @Column(name = "postal_code", length = 10)
    private String postalCode;

    @Column(name = "country", length = 255, columnDefinition = "varchar(255) default 'India'")
    private String country;

}