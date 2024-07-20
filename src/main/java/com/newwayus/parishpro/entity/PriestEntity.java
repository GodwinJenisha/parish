package com.newwayus.parishpro.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "priest")
public class PriestEntity {

    @Id
    @Column(name = "priest_id", length = 12)
    private String priestId;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "ordination_date")
    private String ordinationDate;


    @Column(name = "contact_number", length = 15)
    private String contactNumber;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code", length = 10)
    private String postalCode;

    @Column(name = "country", length = 255, columnDefinition = "varchar(255) default 'India'")
    private String country;

    @Column(name = "comm_address1")
    private String comm_address1;

    @Column(name = "comm_address2")
    private String comm_address2;

    @Column(name = "comm_city")
    private String comm_city;

    @Column(name = "comm_district")
    private String comm_district;

    @Column(name = "comm_state")
    private String comm_state;

    @Column(name = "comm_postal_code", length = 10)
    private String comm_postalCode;

    @Column(name = "comm_country", length = 255, columnDefinition = "varchar(255) default 'India'")
    private String comm_country;

    @Column(name = "startDate")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(length = 1, columnDefinition = "VARCHAR(1) DEFAULT 'A'")
    private String status;

    @Column(name = "parish")
    private String parish;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "priest_parish",
            joinColumns = @JoinColumn(name = "priest_id"),
            inverseJoinColumns = @JoinColumn(name = "parish_id")
    )
    private Set<ParishEntity> parishes;


}
