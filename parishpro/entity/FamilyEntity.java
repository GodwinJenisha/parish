package com.newwayus.parishpro.entity;

import jakarta.persistence.*;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "family")
public class FamilyEntity {

    @Id
    @Column(name = "family_id", length = 6)
    private String familyId;

    @Column(name = "family_name", length = 255)
    private String familyName;

    @Column(name = "registered_date")
    private String registeredDate;

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


//    @OneToOne
//    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
//    private AddressEntity address; // Assuming you have an Address entity
//    @ManyToMany
//    @JoinTable(
//            name = "family_anbiyam",
//            joinColumns = @JoinColumn(name = "family_id"),
//            inverseJoinColumns = @JoinColumn(name = "anbiyam_id")
//    )
//    private Set<AnbiyamEntity> anbiyams;
//
//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "family_member",
//            joinColumns = @JoinColumn(name = "family_id"),
//            inverseJoinColumns = @JoinColumn(name = "member_id")
//    )
//    private Set<MemberEntity> members;

    @Column(length = 1, columnDefinition = "VARCHAR(1) DEFAULT 'Y'")
    private String status;
}
