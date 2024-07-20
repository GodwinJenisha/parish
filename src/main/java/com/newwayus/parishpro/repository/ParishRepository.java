package com.newwayus.parishpro.repository;

import com.newwayus.parishpro.entity.ParishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParishRepository extends JpaRepository<ParishEntity, String> {

//    @Query("SELECT p FROM ParishEntity p JOIN FETCH p.priests WHERE p.parishId = :parishId")
//    Optional<ParishEntity> findParishWithPriestsById(String parishId);
}
