package com.newwayus.parishpro.repository;

import com.newwayus.parishpro.entity.AuditoriumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AuditoriumRepository extends JpaRepository<AuditoriumEntity, Long> {
    boolean existsByEventDateAndEventTime(LocalDate eventDate, String eventTime);

}
