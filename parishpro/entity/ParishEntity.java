package com.newwayus.parishpro.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "parish")
public class ParishEntity {

    @Id
    @Column(name = "parish_id", length = 4)
    private String parishId;

    @Column(name = "name", length = 255, nullable = false)
    private String name;
//
//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
//    private AddressEntity address;

    @Column(name = "contact_number", length = 15)
    private String contactNumber;

    @Column(name = "email", length = 255)
    private String email;

//    @Column(name = "address_id")
//    private String address;

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

    @Column(name = "website", length = 255)
    private String website;

    @Column(name = "diocese", length = 255, nullable = false)
    private String diocese;

    @Column(name = "status", length = 1, columnDefinition = "char(1) default 'Y'")
    private char status;
//    @ManyToMany(mappedBy = "parishes")
//    private Set<AssociationEntity> associations;
//
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "parish_anbiyam",
//            joinColumns = @JoinColumn(name = "parish_id"),
//            inverseJoinColumns = @JoinColumn(name = "anbiyam_id"))
//    private Set<AnbiyamEntity> anbiyams;
//
//    @ManyToMany
//    @JoinTable(
//            name = "parish_priest",
//            joinColumns = @JoinColumn(name = "parish_id"),
//            inverseJoinColumns = @JoinColumn(name = "priest_id")
//    )
//    private Set<PriestEntity> priests;
}