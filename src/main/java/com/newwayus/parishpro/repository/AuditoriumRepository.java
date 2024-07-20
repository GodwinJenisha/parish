package com.newwayus.parishpro.repository;

import com.newwayus.parishpro.entity.AuditoriumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AuditoriumRepository extends JpaRepository<AuditoriumEntity, Long> {
    boolean existsByEventDateAndEventTime(LocalDate eventDate, String eventTime);
    boolean existsByEventDate(LocalDate eventDate);
    boolean existsByEventDateAndEventTimeAndIdNot(LocalDate eventDate, String eventTime, Long id);
    boolean existsByEventDateAndIdNot(LocalDate eventDate, Long id);
    boolean existsByEventDateAndEventTimeNotAndIdNot(LocalDate eventDate, String eventTime, Long id);
    boolean existsByEventDateAndEventTimeNot(LocalDate eventDate, String fullDay);

    boolean existsByEventDateAndEventTimeAndStatusNot(LocalDate eventDate, String eventTime, String status);
    boolean existsByEventDateAndStatusNot(LocalDate eventDate, String status);
    boolean existsByEventDateAndEventTimeNotAndStatusNot(LocalDate eventDate, String eventTime, String status);
    boolean existsByEventDateAndEventTimeAndStatusNotAndIdNot(LocalDate eventDate, String eventTime, String status, Long id);

    boolean existsByEventDateAndStatusNotAndIdNot(LocalDate eventDate, String d, Long auditoriumId);

    boolean existsByEventDateAndEventTimeNotAndStatusNotAndIdNot(LocalDate eventDate, String fullDay, String d, Long auditoriumId);
}
