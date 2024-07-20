package com.newwayus.parishpro.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OccupationService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OccupationRepository occupationRepository;

    public OccupationModel createOccupation(OccupationModel occupationModel) {
        OccupationEntity occupationEntity = modelMapper.map(occupationModel, OccupationEntity.class);
        occupationEntity  = occupationRepository.save(occupationEntity);
        return modelMapper.map(occupationEntity, OccupationModel.class);
    }

    public List<OccupationModel> getalloccupation() {
       return occupationRepository.findAll().stream()
               .map(entity -> modelMapper.map(entity,OccupationModel.class))
                       .collect(Collectors.toList());
    }

    public OccupationModel getOccupationById(String occupationId){
        return  occupationRepository.findById(occupationId)
                .map(entity-> modelMapper.map(entity, OccupationModel.class))
                .orElse(null);

    }

    public OccupationModel updateOccupation(String occupationId,OccupationModel occupationModel) {
        OccupationEntity occupationEntity =modelMapper.map(occupationModel, OccupationEntity.class);
        occupationEntity.setOccupationId(occupationId);
        occupationEntity = occupationRepository.save(occupationEntity);
        return modelMapper.map(occupationEntity, OccupationModel.class);
    }
    public void deleteOccupation(String occupationId) {
        occupationRepository.deleteById(occupationId);
    }

}








