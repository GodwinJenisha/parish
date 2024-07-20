package com.newwayus.parishpro.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "auditorium")
public class AuditoriumEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "memberType")
    private String memberType;

    @Column(name = "memberId")
    private String memberId;

    @Column(name = "memberName")
    private String memberName;

    @Column(name = "nonMemberName")
    private String nonMemberName;

    @Column(name = "father")
    private String father;

    @Column(name = "anbiyam")
    private String anbiyam;

    @Column(name = "contactNumber")
    private String contactNumber;

    @Column(name = "alternateContactNumber")
    private String alternateContactNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "eventType")
    private String eventType;

    @Column(name = "eventTime")
    private String eventTime;

    @Column(name = "eventDate")
    private LocalDate eventDate;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "shareDocument")
    private String shareDocument;

    @Column(name = "shareCertificate")
    private String shareCertificate;

    @Column(name = "advance")
    private String advance;

    @Column(name = "totalRent")
    private String totalRent;

    @Column(name = "balanceRent")
    private String balanceRent;

    @Column(name = "outdoorStage")
    private String outdoorStage;

    @Column(name = "outdoorStageCharge")
    private String outdoorStageCharge;

    @Column(name = "salary1")
    private String salary1;

    @Column(name = "salary1_qty")
    private String salary1Qty;

    @Column(name = "salary1_rate")
    private String salary1Rate;

    @Column(name = "salary2")
    private String salary2;

    @Column(name = "salary2_qty")
    private String salary2Qty;

    @Column(name = "salary2_rate")
    private String salary2Rate;

    @Column(name = "maintenanceCost")
    private String maintenanceCost;

    @Column(name = "maintenanceCost_qty")
    private String maintenanceCostQty;

    @Column(name = "maintenanceCost_rate")
    private String maintenanceCostRate;

    @Column(name = "ebBill")
    private String ebBill;

    @Column(name = "ebBill_qty")
    private String ebBillQty;

    @Column(name = "ebBill_rate")
    private String ebBillRate;

    @Column(name = "dieselPurchased")
    private String dieselPurchased;

    @Column(name = "dieselPurchased_qty")
    private String dieselPurchasedQty;

    @Column(name = "dieselPurchased_rate")
    private String dieselPurchasedRate;

    @Column(name = "gasPurchased")
    private String gasPurchased;

    @Column(name = "gasPurchased_qty")
    private String gasPurchasedQty;

    @Column(name = "gasPurchased_rate")
    private String gasPurchasedRate;

    @Column(name = "advanceReturn")
    private String advanceReturn;

    @Column(name = "advanceReturn_qty")
    private String advanceReturnQty;

    @Column(name = "advanceReturn_rate")
    private String advanceReturnRate;

    @Column(name = "wagesToSweepers")
    private String wagesToSweepers;

    @Column(name = "wagesToSweepers_qty")
    private String wagesToSweepersQty;

    @Column(name = "wagesToSweepers_rate")
    private String wagesToSweepersRate;

    @Column(name = "wagesToVesselsCleaner")
    private String wagesToVesselsCleaner;

    @Column(name = "wagesToVesselsCleaner_qty")
    private String wagesToVesselsCleanerQty;

    @Column(name = "wagesToVesselsCleaner_rate")
    private String wagesToVesselsCleanerRate;

    @Column(name = "wagesToLeafPicker")
    private String wagesToLeafPicker;

    @Column(name = "wagesToLeafPicker_qty")
    private String wagesToLeafPickerQty;

    @Column(name = "wagesToLeafPicker_rate")
    private String wagesToLeafPickerRate;

    @Column(name = "wagesToScavengers")
    private String wagesToScavengers;

    @Column(name = "wagesToScavengers_qty")
    private String wagesToScavengersQty;

    @Column(name = "wagesToScavengers_rate")
    private String wagesToScavengersRate;

    @Column(name = "costOfCleaning")
    private String costOfCleaning;

    @Column(name = "costOfCleaning_qty")
    private String costOfCleaningQty;

    @Column(name = "costOfCleaning_rate")
    private String costOfCleaningRate;

    @Column(name = "serviceCharge")
    private String serviceCharge;

    @Column(name = "total")
    private String total;

    @Column(length = 1, columnDefinition = "VARCHAR(1) DEFAULT 'A'")
    private String status;

}
