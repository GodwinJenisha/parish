package com.newwayus.parishpro.repository;

import com.newwayus.parishpro.entity.StocksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StocksRepository extends JpaRepository<StocksEntity, Integer> {
}
