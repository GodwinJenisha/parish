package com.newwayus.parishpro.model;

import java.util.Date;
import lombok.Data;

@Data
public class FuneralModel {

    private String funeralId;
    private String memberId; // Representing the relationship by Member ID
    private Date funeralDate;
    private Date funeralTime; // Assuming java.util.Date is used to represent time
    private String notes;

    // Constructors, Getters, and Setters
}
