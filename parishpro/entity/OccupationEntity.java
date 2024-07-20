package com.newwayus.parishpro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "occupation")
public class OccupationEntity {

    @Id
    @Column(name = "occupation_id", length = 4, nullable = false)
    String occupationId;

    @Column(name = "occupation_name", length = 255, nullable = false)
    String occupationName;


}
