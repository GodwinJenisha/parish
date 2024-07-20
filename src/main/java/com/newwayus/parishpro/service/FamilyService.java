package com.newwayus.parishpro.service;

import com.newwayus.parishpro.entity.*;
import com.newwayus.parishpro.model.FamilyModel;
import com.newwayus.parishpro.repository.AnbiyamRepository;
import com.newwayus.parishpro.repository.FamilyRepository;
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
public class FamilyService {

    @Autowired
    private AnbiyamRepository anbiyamRepository;

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private ModelMapper modelMapper;

    private static final Logger logger = LoggerFactory.getLogger(FamilyService.class);

    @Transactional
    public FamilyModel createFamily(FamilyModel familyModel) {
        logger.info("Input FamilyModel: {}", familyModel);

        // Mapping from FamilyModel to FamilyEntity
        FamilyEntity familyEntity = modelMapper.map(familyModel, FamilyEntity.class);

        // Fetch AnbiyamEntity objects based on anbiyamIds
        Set<AnbiyamEntity> anbiyams = familyModel.getAnbiyamIds().stream()
                .map(anbiyamId -> {
                    Optional<AnbiyamEntity> anbiyamEntity = anbiyamRepository.findById(anbiyamId);
                    if (!anbiyamEntity.isPresent()) {
                        logger.error("Anbiyam with ID {} not found", anbiyamId);
                        throw new RuntimeException("Anbiyam with ID " + anbiyamId + " not found");
                    }
                    return anbiyamEntity.get();
                })
                .collect(Collectors.toSet());

        // Set the fetched AnbiyamEntity objects in the familyEntity
        familyEntity.setAnbiyams(anbiyams);

        // Save the familyEntity
        familyEntity = familyRepository.save(familyEntity);

        // Mapping from FamilyEntity to FamilyModel and returning
        logger.info("Saved FamilyEntity: {}", familyEntity);
        return modelMapper.map(familyEntity, FamilyModel.class);
    }

    public List<FamilyModel> getAllFamilies() {
        return familyRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, FamilyModel.class))
                .collect(Collectors.toList());
    }

    public FamilyModel getFamilyById(String id) {
        Optional<FamilyEntity> familyEntity = familyRepository.findById(id);
        return familyEntity.map(entity -> modelMapper.map(entity, FamilyModel.class)).orElse(null);
    }

    @Transactional
    public FamilyModel updateFamily(String id, FamilyModel familyModel) {
        // Map the incoming FamilyModel to a FamilyEntity
        FamilyEntity updatedFamilyEntity = modelMapper.map(familyModel, FamilyEntity.class);

        // Set the ID of the existing familyEntity to match the provided ID
        updatedFamilyEntity.setFamilyId(id);

        // Retrieve the existing FamilyEntity from the database
        Optional<FamilyEntity> existingFamilyOptional = familyRepository.findById(id);

        if (existingFamilyOptional.isPresent()) {
            // Get the existing FamilyEntity
            FamilyEntity existingFamilyEntity = existingFamilyOptional.get();

            // Use ModelMapper to automatically update fields
            modelMapper.map(updatedFamilyEntity, existingFamilyEntity);

            // Get the updated anbiyamIds from the updated FamilyModel
            Set<String> updatedAnbiyamIds = familyModel.getAnbiyamIds();

            if (updatedAnbiyamIds != null) {
                // Fetch the associated AnbiyamEntity objects for the updated anbiyamIds
                Set<AnbiyamEntity> updatedAnbiyams = updatedAnbiyamIds.stream()
                        .map(anbiyamId -> {
                            Optional<AnbiyamEntity> anbiyamEntityOptional = anbiyamRepository.findById(anbiyamId);
                            return anbiyamEntityOptional.orElseThrow(() -> new RuntimeException("Anbiyam with ID " + anbiyamId + " not found"));
                        })
                        .collect(Collectors.toSet());

                // Update the set of AnbiyamEntity objects in the existing FamilyEntity
                existingFamilyEntity.setAnbiyams(updatedAnbiyams);
            }

            // Save the updated FamilyEntity
            existingFamilyEntity = familyRepository.save(existingFamilyEntity);

            // Map the updated FamilyEntity back to a FamilyModel and return
            return modelMapper.map(existingFamilyEntity, FamilyModel.class);
        } else {
            // Handle the case where the family with the provided ID does not exist
            throw new RuntimeException("Family with ID " + id + " not found");
        }
    }

    public void deleteFamily(String id){
        try{
            familyRepository.deleteById(id);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
