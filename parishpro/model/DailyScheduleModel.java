package com.newwayus.parishpro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyScheduleModel {

    private int dailyScheduleId;
    private String eventName;
    private String eventDay;
    private LocalTime eventTime;

}
