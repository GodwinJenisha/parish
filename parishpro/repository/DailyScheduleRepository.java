package com.newwayus.parishpro.repository;

import com.newwayus.parishpro.entity.DailyScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyScheduleRepository extends JpaRepository <DailyScheduleEntity, Integer>{

    }

