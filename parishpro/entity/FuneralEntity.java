package com.newwayus.parishpro.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "funeral")
public class FuneralEntity {

    @Id
    @Column(name = "funeral_id", length = 10, nullable = false)
    private String funeralId;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private MemberEntity member;

    @Column(name = "funeral_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date funeralDate;

    @Column(name = "funeral_time")
    @Temporal(TemporalType.TIME)
    private Date funeralTime;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;


}
