package com.newwayus.parishpro.repository;

import com.newwayus.parishpro.entity.PriestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PriestRepository extends JpaRepository<PriestEntity,String> {
    List<PriestEntity> findByNameContainingIgnoreCase(String name);
 //   List<PriestEntity> findByFirstNameContainingIgnoreCase(String firstname);
}
