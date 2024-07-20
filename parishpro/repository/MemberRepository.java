package com.newwayus.parishpro.repository;

import com.newwayus.parishpro.entity.MemberEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, String> {

//    @Override
//    @EntityGraph(attributePaths = {"occupation", "address", "associations"})
//    List<MemberEntity> findAll();
//
//    @Override
//    @EntityGraph(attributePaths = {"occupation", "address", "associations"})
//    Optional<MemberEntity> findById(String id);


}
