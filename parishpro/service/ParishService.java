package com.newwayus.parishpro.service;

import com.newwayus.parishpro.entity.ParishEntity;
import com.newwayus.parishpro.model.AssociationModel;
import com.newwayus.parishpro.model.ParishModel;
import com.newwayus.parishpro.repository.ParishRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParishService {

    @Autowired
    private ParishRepository parishRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ParishModel createParish(ParishModel parishModel) {
        ParishEntity parishEntity = modelMapper.map(parishModel, ParishEntity.class);
        parishEntity = parishRepository.save(parishEntity);
        return modelMapper.map(parishEntity, ParishModel.class);
    }

    public List<ParishModel> getAllParishes(){
        return parishRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, ParishModel.class))
                .collect(Collectors.toList());
    }

    public ParishModel getParishById(String parishId){
        return parishRepository.findById(parishId)
                .map(entity -> modelMapper.map(entity, ParishModel.class))
                .orElse(null);

    }
//    public List<ParishModel> getAllParishes() {
//        List<ParishEntity> praishEntityList = parishRepository.findAll();
//        List<ParishModel> parishModelList = new ArrayList<>();
//
//        for(ParishEntity parishEntity: praishEntityList) {
////            ParishModel parishModel = modelMapper.map(parishEntity, ParishModel.class);
//            ParishModel parishModel = new ParishModel();
//            parishModel.setParishId(parishEntity.getParishId());
//
//            parishModelList.add(parishModel);
//        }
//        return parishModelList;
//    }
//
//    public ParishModel getParishById(String id) {
//        Optional<ParishEntity> parishEntity = parishRepository.findById(id);
//        return parishEntity.map(entity -> modelMapper.map(entity, ParishModel.class)).orElse(null);
//    }

    public ParishModel updateParish(String parishId, ParishModel parishModel) {
        ParishEntity parishEntity = modelMapper.map(parishModel, ParishEntity.class);
        parishEntity.setParishId(parishId);
        parishEntity = parishRepository.save(parishEntity);
        return modelMapper.map(parishEntity, ParishModel.class);
    }

    public void deleteParish(String parishId) {
        parishRepository.deleteById(parishId);
    }

//    public ParishModel getParishWithPriestsById(String parishId) {
//        Optional<ParishEntity> parishEntity = parishRepository.findParishWithPriestsById(parishId);
//        return parishEntity.map(entity -> modelMapper.map(entity, ParishModel.class)).orElse(null);
//    }
}
