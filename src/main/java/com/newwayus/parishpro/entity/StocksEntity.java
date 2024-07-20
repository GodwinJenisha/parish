package com.newwayus.parishpro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stocks")
public class StocksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "category")
    private String category;

    @Column(name = "product")
    private String product;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "rate")
    private String rate;

    @Column(name = "amount")
    private String amount;

    @Column(name = "active_quantity")
    private String activeQuantity;

    @Column(name = "damaged")
    private String damaged;

    @Column(name = "status")
    private String status;

    @Column(name = "productCode")
    private String productCode;

    @Column(name = "description")
    private String description;
}
