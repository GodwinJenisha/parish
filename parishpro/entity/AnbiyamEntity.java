package com.newwayus.parishpro.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@JsonIgnoreProperties("parishes")
@Table(name = "anbiyam")
public class AnbiyamEntity {

    @Id
    @Column(name = "anbiyam_id", length = 11)
    private String anbiyamId;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(length = 1, columnDefinition = "VARCHAR(1) DEFAULT 'A'")
    private String status;



    @Column(name = "president", columnDefinition = "TEXT")
    private String president;

    @Column(name = "vicePresident", columnDefinition = "TEXT")
    private String vicePresident;

    @Column(name = "secretary", columnDefinition = "TEXT")
    private String secretary;


    @Column(name = "jointSecretary", columnDefinition = "TEXT")
    private String jointSecretary;

    @Column(name = "treasurer", columnDefinition = "TEXT")
    private String treasurer;

    @Column(name = "worshipAssociation", columnDefinition = "TEXT")
    private String worshipAssociation;

    @Column(name = "foundationAssociation", columnDefinition = "TEXT")
    private String foundationAssociation;






//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "president_id", referencedColumnName = "member_id")
//    private MemberEntity president;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "vice_president_id", referencedColumnName = "member_id")
//    private MemberEntity vicePresident;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "secretary_id", referencedColumnName = "member_id")
//    private MemberEntity secretary;
//
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "joint_secretary_id", referencedColumnName = "member_id")
//    private MemberEntity jointSecretary;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "treasurer_id", referencedColumnName = "member_id")
//    private MemberEntity treasurer;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "worship_association_id", referencedColumnName = "member_id")
//    private MemberEntity worshipAssociation;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "foundation_association_id", referencedColumnName = "member_id")
//    private MemberEntity foundationAssociation;

//    @ManyToMany(mappedBy = "anbiyams")
//    private Set<FamilyEntity> families;
//
//    @ManyToMany(mappedBy = "anbiyams")
//    private Set<ParishEntity> parishes;

}
