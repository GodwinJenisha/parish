package com.newwayus.parishpro.repository;

import com.newwayus.parishpro.entity.AnbiyamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AnbiyamRepository extends JpaRepository<AnbiyamEntity, String> {

    // Custom query method to find an AnbiyamEntity by name
    AnbiyamEntity findByName(String name);

    // Custom query method to find AnbiyamEntity objects by description containing a certain string
    List<AnbiyamEntity> findByDescriptionContaining(String keyword);

    // Add more custom query methods as needed for your application requirements
}
