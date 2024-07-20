package com.newwayus.parishpro.repository;

import com.newwayus.parishpro.entity.FamilyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface FamilyRepository extends JpaRepository<FamilyEntity, String> {

//    @Query("SELECT f FROM FamilyEntity f JOIN FETCH f.members WHERE f.familyId = :familyId")

    @Query(nativeQuery = true, value = "SELECT f.family_id, f.family_name, f.registered_date, f.address_id, f.status, m.member_id, m.first_name, m.last_name, m.date_of_birth, m.baptism_date, m.communion_date, m.confirmation_date, m.marriage_date, m.death_date, m.occupation_id, m.contact_number, m.email, m.subscription_year, m.address_id , m.status FROM family f JOIN family_member fm ON f.family_id = fm.family_id JOIN member m ON fm.member_id = m.member_id WHERE f.family_id = 'F00002'")
    Optional<FamilyEntity> findFamilyWithMembersById(@Param("familyId") String familyId);
}
