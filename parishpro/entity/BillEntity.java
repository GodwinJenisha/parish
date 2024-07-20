package com.newwayus.parishpro.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bill")
public class BillEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long billId;

    @Column(name = "billType")
    private String billType;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "member")
    private String member;

    @Column(name = "nonMember")
    private String nonMember;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "totalAmount")
    private String totalAmount;

    @Column(name = "advance")
    private String advance;

    @Column(name = "balance")
    private String balance;

    @Column(name = "remarks")
    private String remarks;







}
