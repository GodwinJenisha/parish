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

//    @Id
//    @Column(name = "booking_id", length = 10, nullable = false)
//    private String bookingId;
//
//    @Column(name = "booking_date", nullable = false)
//    @Temporal(TemporalType.DATE)
//    private Date bookingDate;
//
//    @Column(name = "time_slot", nullable = false)
//    @Enumerated(EnumType.STRING)
//    private TimeSlot timeSlot;
//
//    @ManyToOne
//    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
//    private MemberEntity member;
//
//    @ManyToOne
//    @JoinColumn(name = "non_member_id", referencedColumnName = "non_member_id")
//    private NonMemberEntity nonMember;
//
//    // Enums for time slots
//    public enum TimeSlot {
//        AM, PM
//    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "memberName")
    private String memberName;

    @Column(name = "contactNumber")
    private String contactNumber;

    @Column(name = "alternateContactNumber")
    private String alternateContactNumber;

    @Column(name = "eventType")
    private String eventType;

    @Column(name = "eventTime")
    private String eventTime;

    @Column(name = "eventDate")
    private LocalDate eventDate;

    @Column(name = "remarks")
    private String remarks;





}
