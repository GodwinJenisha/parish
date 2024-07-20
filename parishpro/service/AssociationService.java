package com.newwayus.parishpro.service;

import com.newwayus.parishpro.entity.AssociationEntity;
import com.newwayus.parishpro.model.AssociationModel;
import com.newwayus.parishpro.repository.AssociationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssociationService {

    @Autowired
    private AssociationRepository associationRepository;

    @Autowired
    private ModelMapper modelMapper;


    public AssociationModel createAssociation(AssociationModel associationModel) {
        AssociationEntity associationEntity = modelMapper.map(associationModel, AssociationEntity.class);
        associationEntity = associationRepository.save(associationEntity);
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

    public AssociationModel updateAssociation(String associationId, AssociationModel associationModel) {
        AssociationEntity associationEntity = modelMapper.map(associationModel, AssociationEntity.class);
        associationEntity.setAssociationId(associationId);
        associationEntity = associationRepository.save(associationEntity);
        return modelMapper.map(associationEntity, AssociationModel.class);
    }

    public void deleteAssociation(String associationId) {

        associationRepository.deleteById(associationId);
    }



}