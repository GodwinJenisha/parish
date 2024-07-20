package com.newwayus.parishpro.service;

import com.newwayus.parishpro.entity.AssociationEntity;
import com.newwayus.parishpro.entity.ParishEntity;
import com.newwayus.parishpro.model.AssociationModel;
import com.newwayus.parishpro.repository.AssociationRepository;
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
public class AssociationService {

    @Autowired
    private AssociationRepository associationRepository;

    @Autowired
    private ParishRepository parishRepository;

    @Autowired
    private ModelMapper modelMapper;

    private static final Logger logger = LoggerFactory.getLogger(AssociationService.class);


    @Transactional
    public AssociationModel createAssociation(AssociationModel associationModel) {
        logger.info("Input AssociationModel: {}", associationModel);

        // Mapping from AssociationModel to AssociationEntity
        AssociationEntity associationEntity = modelMapper.map(associationModel, AssociationEntity.class);

        // Fetch ParishEntity objects based on parishIds
        Set<ParishEntity> parishes = associationModel.getParishIds().stream()
                .map(parishId -> {
                    Optional<ParishEntity> parishEntity = parishRepository.findById(parishId);
                    if (!parishEntity.isPresent()) {
                        logger.error("Parish with ID {} not found", parishId);
                        throw new RuntimeException("Parish with ID " + parishId + " not found");
                    }
                    return parishEntity.get();
                })
                .collect(Collectors.toSet());

        // Set the fetched parishes in the AssociationEntity
        associationEntity.setParishes(parishes);

        // Save the AssociationEntity
        associationEntity = associationRepository.save(associationEntity);

        // Mapping from AssociationEntity to AssociationModel and returning
        logger.info("Saved AssociationEntity: {}", associationEntity);
        return modelMapper.map(associationEntity, AssociationModel.class);
    }

    public List<AssociationModel> getAllAssociation() {
        return associationRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, AssociationModel.class))
                .collect(Collectors.toList());
    }

    public AssociationModel getAssociationById(String associationId) {
        return associationRepository.findById(associationId)
                .map(entity -> modelMapper.map(entity, AssociationModel.class))
                .orElse(null);
    }

    @Transactional
    public AssociationModel updateAssociation(String id, AssociationModel associationModel) {
        // Map the incoming AssociationModel to a AssociationEntity
        AssociationEntity updatedAssociationEntity = modelMapper.map(associationModel, AssociationEntity.class);
        updatedAssociationEntity.setAssociationId(id); // Set the ID

        // Retrieve the existing AssociationEntity from the database
        Optional<AssociationEntity> existingAssociationOptional = associationRepository.findById(id);

        if (existingAssociationOptional.isPresent()) {
            // Get the existing AssociationEntity
            AssociationEntity existingAssociationEntity = existingAssociationOptional.get();

            // Use ModelMapper to automatically update fields
            modelMapper.map(updatedAssociationEntity, existingAssociationEntity);

            // Get the updated parishIds from the updated AssociationModel
            Set<String> updatedParishIds = associationModel.getParishIds();

            if (updatedParishIds != null) {
                // Fetch the associated ParishEntity objects for the updated parishIds
                Set<ParishEntity> updatedParishes = updatedParishIds.stream()
                        .map(parishId -> {
                            Optional<ParishEntity> parishEntityOptional = parishRepository.findById(parishId);
                            return parishEntityOptional.orElseThrow(() -> new RuntimeException("Parish with ID " + parishId + " not found"));
                        })
                        .collect(Collectors.toSet());

                // Update the set of parishes in the existing AssociationEntity
                existingAssociationEntity.setParishes(updatedParishes);
            }

            // Save the updated AssociationEntity (including associated Parishes)
            existingAssociationEntity = associationRepository.save(existingAssociationEntity);

            // Map the updated AssociationEntity back to a AssociationModel and return
            return modelMapper.map(existingAssociationEntity, AssociationModel.class);
        } else {
            // Handle the case where the association with the provided ID does not exist
            throw new RuntimeException("Association with ID " + id + " not found");
        }
    }


    public void deleteAssociation(String associationId) {
        associationRepository.deleteById(associationId);
    }
}
