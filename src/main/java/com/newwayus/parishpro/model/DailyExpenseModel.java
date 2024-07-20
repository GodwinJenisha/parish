package com.newwayus.parishpro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyExpenseModel {

    private Long dailyExpenseId;
    private LocalDate date;
    private String remarks;
    private String name;
    private String description;
//    private int quantity;
    private Double amount;
    private Double incomeAmount;
    private String incomeDescription;
    private String type;




}
