package com.newwayus.parishpro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssociationModel {

    private String associationId;
    private String name;
    private String description;
    private String status;
    private String president;
    private String vicePresident;
    private String secretary;
    private String treasurer;
    private String parish;
//    private Set<String> memberIds; // Collection of Member IDs

    private Set<String> parishIds = new HashSet<>();
}
