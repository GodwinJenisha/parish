package com.newwayus.parishpro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillModel {

    private Long billId;
    private String billType;
    private LocalDate date;
    private String member;
    private String nonMember;
    private int quantity;
    private String totalAmount;
    private String advance;
    private String balance;
    private String remarks;



}
