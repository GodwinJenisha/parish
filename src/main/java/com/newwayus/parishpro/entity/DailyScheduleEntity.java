package com.newwayus.parishpro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dailySchedule")
public class DailyScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "daily_schedule_id")
    private int dailyScheduleId;

    @Column(name = "eventName")
    private String eventName;

    @Column(name = "eventDay")
    private String eventDay;

    @Column(name = "eventTime")
    private LocalTime eventTime;
}


