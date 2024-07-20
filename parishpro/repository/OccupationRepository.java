package com.newwayus.parishpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OccupationRepository extends JpaRepository<OccupationEntity,String>{
//    List<OccupationEntity> findByOccupationNameContainingIgnoreCase(String occupationName);
}
