package com.newwayus.parishpro.service;

import com.newwayus.parishpro.entity.AnbiyamEntity;
import com.newwayus.parishpro.entity.ParishEntity;
import com.newwayus.parishpro.entity.PriestEntity;
import com.newwayus.parishpro.model.AnbiyamModel;
import com.newwayus.parishpro.model.ParishModel;
import com.newwayus.parishpro.model.PriestModel;
import com.newwayus.parishpro.repository.PriestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PriestService {
    @Autowired
    PriestRepository priestRepository;

    @Autowired
    ModelMapper modelMapper;

  public PriestModel createPriest(PriestModel priestModel){
      PriestEntity priestEntity = modelMapper.map(priestModel,PriestEntity.class);
      priestEntity = priestRepository.save(priestEntity);
      return modelMapper.map(priestEntity, PriestModel.class);
  }


  public List<PriestModel> getAllPriest(){
      return priestRepository.findAll().stream()
              .map(entity -> modelMapper.map(entity, PriestModel.class))
              .collect(Collectors.toList());
  }

  public PriestModel getPriestById(String id){
      Optional<PriestEntity> priestEntity = priestRepository.findById(id);
      return priestEntity.map(entity -> modelMapper.map(entity, PriestModel.class)).orElse(null);
  }

  public PriestModel updatePriest(String id, PriestModel priestModel){
      PriestEntity priestEntity = modelMapper.map(priestModel, PriestEntity.class);
      priestEntity.setPriestId(id);
      priestEntity = priestRepository.save(priestEntity);
      return modelMapper.map(priestEntity, PriestModel.class);
  }

  public void deletePriest(String id){
      try{
          priestRepository.deleteById(id);
      }catch (Exception e){
          e.printStackTrace();
      }
    }


//    public List<PriestModel> getAllPriest() {
//        List<PriestEntity> PriestEntityList = priestRepository.findAll();
//        List<PriestModel> priestModelList = new ArrayList<>();
//        for (PriestEntity priestEntity : PriestEntityList) {
//            PriestModel priestModel = modelMapper.map(priestEntity, PriestModel.class);
//            priestModelList.add(priestModel);
//        }
//        return priestModelList;
//
//    }
//
//    //post
//    public void createPriest(PriestModel priestModel) {
//        PriestEntity priestEntity = modelMapper.map(priestModel, PriestEntity.class);
//        priestRepository.save(priestEntity);
//
//    }
//
//    //delete
//    public void deletepriest(String priestId) {
//        priestRepository.deleteById(priestId);
//    }
//
//    //getPriestbyid
//    public PriestModel getPriestById(String id) {
//        Optional<PriestEntity> priestEntity = priestRepository.findById(id);
//        return priestEntity.map(entity -> modelMapper.map(entity, PriestModel.class)).orElse(null);
//    }
//
//    //update
//    public PriestModel updatePriest(String id, PriestModel priestModel) {
//        PriestEntity priestEntity1 = priestRepository.findById(id).orElse(null);
//        PriestEntity priestEntity = modelMapper.map(priestModel, PriestEntity.class);
//        priestEntity1.setFirstName(priestEntity.getFirstName());
//        priestEntity1.setLastName(priestEntity.getLastName());
//        priestEntity = priestRepository.save(priestEntity1);
//        return modelMapper.map(priestEntity, PriestModel.class);
//    }
//
//
//    public List<PriestModel> getPriestByfirstName(String priestfirstName) {
//    List<PriestEntity> priestEntityList = priestRepository.findByFirstNameContainingIgnoreCase(priestfirstName);
//
//    return priestEntityList.stream()
//            .map(entity -> modelMapper.map(entity, PriestModel.class))
//            .collect(Collectors.toList());
//}

}



