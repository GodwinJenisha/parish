package com.newwayus.parishpro.service;

import com.newwayus.parishpro.entity.FamilyEntity;
import com.newwayus.parishpro.entity.MemberEntity;
import com.newwayus.parishpro.model.MemberModel;
import com.newwayus.parishpro.repository.FamilyRepository;
import com.newwayus.parishpro.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private ModelMapper modelMapper;

    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

    @Transactional
    public MemberModel createMember(MemberModel memberModel) {
        logger.info("Input MemberModel: {}", memberModel);

        // Mapping from MemberModel to MemberEntity
        MemberEntity memberEntity = modelMapper.map(memberModel, MemberEntity.class);

        // Fetch FamilyEntity objects based on familyIds
        Set<FamilyEntity> families = memberModel.getFamilyIds().stream()
                .map(familyId -> {
                    Optional<FamilyEntity> familyEntity = familyRepository.findById(familyId);
                    if (!familyEntity.isPresent()) {
                        logger.error("Family with ID {} not found", familyId);
                        throw new RuntimeException("Family with ID " + familyId + " not found");
                    }
                    return familyEntity.get();
                })
                .collect(Collectors.toSet());

        // Set the fetched families in the MemberEntity
        memberEntity.setFamilies(families);

        // Save the MemberEntity
        memberEntity = memberRepository.save(memberEntity);

        // Mapping from MemberEntity to MemberModel and returning
        logger.info("Saved MemberEntity: {}", memberEntity);
        return modelMapper.map(memberEntity, MemberModel.class);
    }

    public List<MemberModel> getAllMembers() {
        return memberRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, MemberModel.class))
                .collect(Collectors.toList());
    }

    public MemberModel getMemberById(String memberId) {
        return memberRepository.findById(memberId)
                .map(entity -> modelMapper.map(entity, MemberModel.class))
                .orElse(null);
    }

    @Transactional
    public MemberModel updateMember(String id, MemberModel memberModel) {
        // Map the incoming MemberModel to a MemberEntity
        MemberEntity updatedMemberEntity = modelMapper.map(memberModel, MemberEntity.class);

        // Set the ID of the existing memberEntity to match the provided ID
        updatedMemberEntity.setMemberId(id);

        // Retrieve the existing MemberEntity from the database
        Optional<MemberEntity> existingMemberOptional = memberRepository.findById(id);

        if (existingMemberOptional.isPresent()) {
            // Get the existing MemberEntity
            MemberEntity existingMemberEntity = existingMemberOptional.get();

            // Update the fields of the existing entity with the values from the updated entity
            existingMemberEntity.setName(updatedMemberEntity.getName());
            // Update other fields as needed...

            // Use ModelMapper to automatically update fields
            modelMapper.map(updatedMemberEntity, existingMemberEntity);

            // Get the updated familyIds from the updated MemberModel
            Set<String> updatedFamilyIds = memberModel.getFamilyIds();

            if (updatedFamilyIds != null) {
                // Fetch the associated FamilyEntity objects for the updated familyIds
                Set<FamilyEntity> updatedFamilies = updatedFamilyIds.stream()
                        .map(familyId -> {
                            Optional<FamilyEntity> familyEntityOptional = familyRepository.findById(familyId);
                            return familyEntityOptional.orElseThrow(() -> new RuntimeException("Family with ID " + familyId + " not found"));
                        })
                        .collect(Collectors.toSet());

                // Update the set of families in the existing MemberEntity
                existingMemberEntity.setFamilies(updatedFamilies);
            }

            // Save the updated MemberEntity
            existingMemberEntity = memberRepository.save(existingMemberEntity);
            // Map the updated MemberEntity back to a MemberModel and return
            return modelMapper.map(existingMemberEntity, MemberModel.class);
        } else {
            // Handle the case where the member with the provided ID does not exist
            throw new RuntimeException("Member with ID " + id + " not found");
        }
    }

    public void deleteMember(String memberId) {
        memberRepository.deleteById(memberId);
    }
}
