package com.newwayus.parishpro.entity;

import java.util.Set;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "association")
public class AssociationEntity {

    @Id
    @Column(name = "association_id", length = 5)
    private String associationId;

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


    @Column(name = "treasurer", columnDefinition = "TEXT")
    private String treasurer;



    @ManyToMany
    @JoinTable(
            name = "association_member",
            joinColumns = @JoinColumn(name = "association_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private Set<MemberEntity> members;

    @ManyToMany
    @JoinTable(
            name = "association_parish",
            joinColumns = @JoinColumn(name = "association_id"),
            inverseJoinColumns = @JoinColumn(name = "parish_id")
    )
    private Set<ParishEntity> parishes;
}
