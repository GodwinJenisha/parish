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
@Table(name = "anbiyam")
public class AnbiyamEntity {

    @Id
    @Column(name = "anbiyam_id", length = 255)
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

    @Column(name = "parish")
    private String parish;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "anbiyam_parish",
            joinColumns = @JoinColumn(name = "anbiyam_id"),
            inverseJoinColumns = @JoinColumn(name = "parish_id")
    )
    private Set<ParishEntity> parishes;

    @ManyToMany(mappedBy = "anbiyams")
    private Set<FamilyEntity> families;



}
