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

//    private MemberModel president;
//    private MemberModel vicePresident;
//    private MemberModel secretary;
//    private MemberModel jointSecretary;
//    private MemberModel treasurer;
//    private MemberModel worshipAssociation;
//    private MemberModel foundationAssociation;

    private Set<String> familyIds;
    private Set<String> parishIds;
}
