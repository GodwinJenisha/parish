package com.newwayus.parishpro.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AuditoriumModel {

//    private String bookingId;
//    private Date bookingDate;
//    private AuditoriumBookingEntity.TimeSlot timeSlot;
//    private String memberId;
//    private String nonMemberId;


    private Long id;
    private String memberName;
    private String contactNumber;
    private String alternateContactNumber;
    private String eventType;
    private String eventTime;
    private LocalDate eventDate;
    private String remarks;

}
