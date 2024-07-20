package com.newwayus.parishpro.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StocksModel {

    private int id;
    private String category;
    private String product;
    private String quantity;
    private String rate;
    private String amount;
    private String activeQuantity;
    private String damaged;
    private String status;
    private String productCode;
    private String description;
}