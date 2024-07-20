package com.newwayus.parishpro.service;

import com.newwayus.parishpro.entity.AnbiyamEntity;
import com.newwayus.parishpro.entity.MemberEntity;
import com.newwayus.parishpro.entity.ParishEntity;
import com.newwayus.parishpro.entity.PriestEntity;
import com.newwayus.parishpro.model.AnbiyamModel;
import com.newwayus.parishpro.model.MemberModel;
import com.newwayus.parishpro.model.ParishModel;
import com.newwayus.parishpro.model.PriestModel;
import com.newwayus.parishpro.repository.AnbiyamRepository;
import com.newwayus.parishpro.repository.ParishRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AnbiyamService {

    @Autowired
    private AnbiyamRepository anbiyamRepository;

    @Autowired
    private ParishRepository parishRepository;

    @Autowired
    private ModelMapper modelMapper;

    private static final Logger logger = LoggerFactory.getLogger(AnbiyamService.class);


    @Transactional
    public AnbiyamModel createAnbiyam(AnbiyamModel anbiyamModel) {
        logger.info("Input AnbiyamModel: {}", anbiyamModel);

        // Mapping from AnbiyamModel to AnbiyamEntity
        AnbiyamEntity anbiyamEntity = modelMapper.map(anbiyamModel, AnbiyamEntity.class);

        // Fetch ParishEntity objects based on parishIds
        Set<ParishEntity> parishes = anbiyamModel.getParishIds().stream()
                .map(parishId -> {
                    Optional<ParishEntity> parishEntity = parishRepository.findById(parishId);
                    if (!parishEntity.isPresent()) {
                        logger.error("Parish with ID {} not found", parishId);
                        throw new RuntimeException("Parish with ID " + parishId + " not found");
                    }
                    return parishEntity.get();
                })
                .collect(Collectors.toSet());

        // Set the fetched parishes in the AnbiyamEntity
        anbiyamEntity.setParishes(parishes);

        // Save the PriestEntity
        anbiyamEntity = anbiyamRepository.save(anbiyamEntity);

        // Mapping from PriestEntity to PriestModel and returning
        logger.info("Saved AnbiyamEntity: {}", anbiyamEntity);
        return modelMapper.map(anbiyamEntity, AnbiyamModel.class);
    }

    public List<AnbiyamModel> getAllAnbiyams() {
        return anbiyamRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, AnbiyamModel.class))
                .collect(Collectors.toList());
    }

    public AnbiyamModel getAnbiyamById(String id) {
        Optional<AnbiyamEntity> anbiyamEntity = anbiyamRepository.findById(id);
        return anbiyamEntity.map(entity -> modelMapper.map(entity, AnbiyamModel.class)).orElse(null);
    }

    @Transactional
    public AnbiyamModel updateAnbiyam(String id, AnbiyamModel anbiyamModel) {
        // Map the incoming AnbiyamModel to an AnbiyamEntity
        AnbiyamEntity updatedAnbiyamEntity = modelMapper.map(anbiyamModel, AnbiyamEntity.class);
        updatedAnbiyamEntity.setAnbiyamId(id); // Set the ID

        // Retrieve the existing AnbiyamEntity from the database
        Optional<AnbiyamEntity> existingAnbiyamOptional = anbiyamRepository.findById(id);

        if (existingAnbiyamOptional.isPresent()) {
            // Get the existing AnbiyamEntity
            AnbiyamEntity existingAnbiyamEntity = existingAnbiyamOptional.get();

            // Use ModelMapper to automatically update fields
            modelMapper.map(updatedAnbiyamEntity, existingAnbiyamEntity);

            // Get the updated parishIds from the updated AnbiyamModel
            Set<String> updatedParishIds = anbiyamModel.getParishIds();

            if (updatedParishIds != null) {
                // Fetch the associated ParishEntity objects for the updated parishIds
                Set<ParishEntity> updatedParishes = updatedParishIds.stream()
                        .map(parishId -> {
                            Optional<ParishEntity> parishEntityOptional = parishRepository.findById(parishId);
                            return parishEntityOptional.orElseThrow(() -> new RuntimeException("Parish with ID " + parishId + " not found"));
                        })
                        .collect(Collectors.toSet());

                // Update the set of parishes in the existing AnbiyamEntity
                existingAnbiyamEntity.setParishes(updatedParishes);
            }

            // Save the updated AnbiyamEntity (including associated Parishes)
            existingAnbiyamEntity = anbiyamRepository.save(existingAnbiyamEntity);

            // Map the updated AnbiyamEntity back to an AnbiyamModel and return
            return modelMapper.map(existingAnbiyamEntity, AnbiyamModel.class);
        } else {
            // Handle the case where the Anbiyam with the provided ID does not exist
            throw new RuntimeException("Anbiyam with ID " + id + " not found");
        }
    }


    public void deleteAnbiyam(String id) {
        try {
            anbiyamRepository.deleteById(id);
            // Add logging statements here
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
        }
    }
}
