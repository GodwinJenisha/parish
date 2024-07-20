package com.newwayus.parishpro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnbiyamModel {

    private String anbiyamId;
    private String name;
    private String description;
    private String status;
    private String president;
    private String vicePresident;
    private String secretary;
    private String jointSecretary;
    private String treasurer;
    private String worshipAssociation;
    private String foundationAssociation;
    private String family;
    private String parish;

    private Set<String> parishIds;
}
