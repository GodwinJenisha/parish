package com.newwayus.parishpro.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AuditoriumModel {

    private Long id;
    private String memberType;
    private String memberId;
    private String memberName;
    private String nonMemberName;
    private String shareDocument;
    private String shareCertificate;
    private String father;
    private String anbiyam;
    private String contactNumber;
    private String alternateContactNumber;
    private String email;
    private String eventType;
    private String eventTime;
    private LocalDate eventDate;
    private String remarks;

    private String advance;
    private String totalRent;
    private String balanceRent;

    private String outdoorStage;
    private String outdoorStageCharge;


    // Salary to In-Charge:
    private String salary1;
    private String salary1Qty;
    private String salary1Rate;

    // Bonus to in-charge
    private String salary2;
    private String salary2Qty;
    private String salary2Rate;

    //Maintenance
    private String maintenanceCost;
    private String maintenanceCostQty;
    private String maintenanceCostRate;

    // Electicity
    private String ebBill;
    private String ebBillQty; // Units
    private String ebBillRate; // Rate per unit

    // DieselPurchased
    private String dieselPurchased;
    private String dieselPurchasedQty; // Liters
    private String dieselPurchasedRate; // rate per liter

    // gas purchased
    private String gasPurchased;
    private String gasPurchasedQty; // Kg
    private String gasPurchasedRate; // Rate per Kg

    // advanceReturn
    private String advanceReturn;
    private String advanceReturnQty;
    private String advanceReturnRate;

    // wagesToSweepers
    private String wagesToSweepers;
    private String wagesToSweepersQty; // no of sweepers
    private String wagesToSweepersRate; // rate per

    // wagesToVesselsCleaner
    private String wagesToVesselsCleaner;
    private String wagesToVesselsCleanerQty;
    private String wagesToVesselsCleanerRate;

    // wagesToLeafPicker
    private String wagesToLeafPicker;
    private String wagesToLeafPickerQty;
    private String wagesToLeafPickerRate;

    // wages To Scavengers
    private String wagesToScavengers;
    private String wagesToScavengersQty;
    private String wagesToScavengersRate;

    // cleaning supplies
    private String costOfCleaning;
    private String costOfCleaningQty;
    private String costOfCleaningRate;

    private String serviceCharge;
    private String total;

    private String status;

}
