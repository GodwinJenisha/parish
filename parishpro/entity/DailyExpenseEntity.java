package com.newwayus.parishpro.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.*;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "daily_expenses")
public class DailyExpenseEntity {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long dailyExpenseId;

        @Column(name = "date")
        private LocalDate date;

        @Column(name = "remarks")
        private String remarks;

        @Column(name = "description")
        private String description;

//        @Column(name = "quantity")
//        private int quantity;

        @Column(name = "amount")
        private Double amount;

        @Column(name = "incomeAmount")
        private Double incomeAmount;

        @Column(name = "incomeDescription")
        private String incomeDescription;

        @Column(name = "type")
        private String type;



}






