package com.newwayus.parishpro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "non_member")
public class NonMemberEntity {

    @Id
    @Column(name = "non_member_id", length = 11)
    private String nonMemberId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;



//    @OneToOne
//    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
//    private AddressEntity address;

}
