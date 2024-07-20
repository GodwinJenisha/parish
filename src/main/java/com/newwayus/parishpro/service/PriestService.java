package com.newwayus.parishpro.service;

import com.newwayus.parishpro.entity.ParishEntity;
import com.newwayus.parishpro.entity.PriestEntity;
import com.newwayus.parishpro.model.PriestModel;
import com.newwayus.parishpro.repository.PriestRepository;
import com.newwayus.parishpro.repository.ParishRepository;
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
public class PriestService {
    @Autowired
    private PriestRepository priestRepository;

    @Autowired
    private ParishRepository parishRepository;

    @Autowired
    private ModelMapper modelMapper;

    private static final Logger logger = LoggerFactory.getLogger(PriestService.class);

    @Transactional
    public PriestModel createPriest(PriestModel priestModel) {
        logger.info("Input PriestModel: {}", priestModel);

        // Mapping from PriestModel to PriestEntity
        PriestEntity priestEntity = modelMapper.map(priestModel, PriestEntity.class);

        // Fetch ParishEntity objects based on parishIds
        Set<ParishEntity> parishes = priestModel.getParishIds().stream()
                .map(parishId -> {
                    Optional<ParishEntity> parishEntity = parishRepository.findById(parishId);
                    if (!parishEntity.isPresent()) {
                        logger.error("Parish with ID {} not found", parishId);
                        throw new RuntimeException("Parish with ID " + parishId + " not found");
                    }
                    return parishEntity.get();
                })
                .collect(Collectors.toSet());

        // Set the fetched parishes in the PriestEntity
        priestEntity.setParishes(parishes);

        // Save the PriestEntity
        priestEntity = priestRepository.save(priestEntity);

        // Mapping from PriestEntity to PriestModel and returning
        logger.info("Saved PriestEntity: {}", priestEntity);
        return modelMapper.map(priestEntity, PriestModel.class);
    }

    public List<PriestModel> getAllPriest(){
        return priestRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, PriestModel.class))
                .collect(Collectors.toList());
    }
    public PriestModel getPriestById(String id) {
        System.out.println("Fetching priest with ID: " + id);
        Optional<PriestEntity> priestEntityOptional = priestRepository.findById(id);

        if (priestEntityOptional.isPresent()) {
            System.out.println("Priest found with ID: " + id);
            // Map the PriestEntity to PriestModel
            PriestEntity priestEntity = priestEntityOptional.get();
            PriestModel priestModel = modelMapper.map(priestEntity, PriestModel.class);

            // Get the parishIds associated with the PriestEntity
            Set<String> parishIds = priestEntity.getParishes().stream()
                    .map(ParishEntity::getParishId)
                    .collect(Collectors.toSet());

            System.out.println("Parish IDs associated with priest " + id + ": " + parishIds);
            // Set the parishIds in the PriestModel
            priestModel.setParishIds(parishIds);

            return priestModel;
        } else {
            System.out.println("Priest not found with ID: " + id);

            return null; // Or throw an exception if needed
        }
    }


    @Transactional
    public PriestModel updatePriest(String id, PriestModel priestModel) {
        // Map the incoming PriestModel to a PriestEntity
        PriestEntity updatedPriestEntity = modelMapper.map(priestModel, PriestEntity.class);
        updatedPriestEntity.setPriestId(id); // Set the ID

        // Retrieve the existing PriestEntity from the database
        Optional<PriestEntity> existingPriestOptional = priestRepository.findById(id);

        if (existingPriestOptional.isPresent()) {
            // Get the existing PriestEntity
            PriestEntity existingPriestEntity = existingPriestOptional.get();

            // Use ModelMapper to automatically update fields
            modelMapper.map(updatedPriestEntity, existingPriestEntity);

            // Get the updated parishIds from the updated PriestModel
            Set<String> updatedParishIds = priestModel.getParishIds();

            if (updatedParishIds != null) {
                // Fetch the associated ParishEntity objects for the updated parishIds
                Set<ParishEntity> updatedParishes = updatedParishIds.stream()
                        .map(parishId -> {
                            Optional<ParishEntity> parishEntityOptional = parishRepository.findById(parishId);
                            return parishEntityOptional.orElseThrow(() -> new RuntimeException("Parish with ID " + parishId + " not found"));
                        })
                        .collect(Collectors.toSet());

                // Update the set of parishes in the existing PriestEntity
                existingPriestEntity.setParishes(updatedParishes);
            }

            // Save the updated PriestEntity (including associated Parishes)
            existingPriestEntity = priestRepository.save(existingPriestEntity);

            // Map the updated PriestEntity back to a PriestModel and return
            return modelMapper.map(existingPriestEntity, PriestModel.class);
        } else {
            // Handle the case where the priest with the provided ID does not exist
            throw new RuntimeException("Priest with ID " + id + " not found");
        }
    }



    public void deletePriest(String id){
        try{
            priestRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}



