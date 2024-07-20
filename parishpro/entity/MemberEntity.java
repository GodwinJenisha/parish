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
@Table(name = "member")
public class MemberEntity {

    @Id
    @Column(name = "member_id", length = 11 )
    private String memberId;


    @Column(name = "name", length = 255 )
    private String name;

    @Column(name = "gender", length = 6)
    private String gender;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "baptism_date")
    @Temporal(TemporalType.DATE)
    private Date baptismDate;

    @Column(name = "communion_date")
    @Temporal(TemporalType.DATE)
    private Date communionDate;

    @Column(name = "confirmation_date")
    @Temporal(TemporalType.DATE)
    private Date confirmationDate;

    @Column(name = "marriage_date")
    @Temporal(TemporalType.DATE)
    private Date marriageDate;

    @Column(name = "death_date")
    @Temporal(TemporalType.DATE)
    private Date deathDate;

//    @ManyToOne
//    @JoinColumn(name = "occupation_id", referencedColumnName = "occupation_id")
//    private OccupationEntity occupation;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "contact_number", length = 15)
    private String contactNumber;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "subscription_year")
    private Integer subscriptionYear;

//    @Column(name = "address_id")
//    private String address;

//    @Column(name = "permanent_address_id")
//    private String permanentAddress;

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

    @Column(name = "father_id")
    private String father;

    @Column(name = "mother_id")
    private String mother;

    @Column(name = "god_father_id")
    private String godFather;

    @Column(name = "god_mother_id")
    private String godMother;

    @Column(length = 1, columnDefinition = "VARCHAR(1) DEFAULT 'Y'")
    private String status;




//    @ManyToOne
//    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
//    private AddressEntity address;
//
//    @ManyToOne
//    @JoinColumn(name = "permanent_address_id", referencedColumnName = "address_id")
//    private AddressEntity permanentAddress;
//
//    @ManyToOne
//    @JoinColumn(name = "father_id", referencedColumnName = "member_id")
//    private MemberEntity father;
//
//    @ManyToOne
//    @JoinColumn(name = "mother_id", referencedColumnName = "member_id")
//    private MemberEntity mother;
//
//    @ManyToOne
//    @JoinColumn(name = "god_father_id", referencedColumnName = "member_id")
//    private MemberEntity godFather;
//
//    @ManyToOne
//    @JoinColumn(name = "god_mother_id", referencedColumnName = "member_id")
//    private MemberEntity godMother;
//
//    @Column(length = 1, columnDefinition = "VARCHAR(1) DEFAULT 'Y'")
//    private String status;
//
//    @ManyToMany(mappedBy = "members", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Set<AssociationEntity> associations;

//    @ManyToMany(mappedBy = "members")
//    private Set<FamilyEntity> families;
}
