package com.newwayus.parishpro.repository;

import com.newwayus.parishpro.entity.DailyExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyExpenseRepository extends JpaRepository<DailyExpenseEntity, Long> {
    // You can add custom query methods here if needed

}
