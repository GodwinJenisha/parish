package com.newwayus.parishpro.service;

import com.newwayus.parishpro.entity.FamilyEntity;
import com.newwayus.parishpro.entity.MemberEntity;
import com.newwayus.parishpro.model.FamilyModel;
import com.newwayus.parishpro.repository.FamilyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private ModelMapper modelMapper;

    public FamilyModel createFamily(FamilyModel familyModel) {
        FamilyEntity familyEntity = modelMapper.map(familyModel, FamilyEntity.class);
        familyEntity = familyRepository.save(familyEntity);
        return modelMapper.map(familyEntity, FamilyModel.class);
    }

    public List<FamilyModel> getAllFamilies() {
        return familyRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, FamilyModel.class))
                .collect(Collectors.toList());
    }

    public FamilyModel getFamilyById(String id) {
        Optional<FamilyEntity> familyEntity = familyRepository.findById(id);

////        if(familyEntity.isEmpty())
//        FamilyEntity familyEntity1 = familyEntity.get();
//        Set<MemberEntity> m = familyEntity1.getMembers();
//
//
//
//        System.out.println(m);

        return familyEntity.map(entity -> modelMapper.map(entity, FamilyModel.class)).orElse(null);
    }

    public FamilyModel updateFamily(String id, FamilyModel familyModel) {
        FamilyEntity familyEntity = modelMapper.map(familyModel, FamilyEntity.class);
        familyEntity.setFamilyId(id);
        familyEntity = familyRepository.save(familyEntity);
        return modelMapper.map(familyEntity, FamilyModel.class);
    }

    public void deleteFamily(String id){
        try{
            familyRepository.deleteById(id);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    public void deleteFamily(String id) {
//
//        familyRepository.deleteById(id);
//    }
//
//    public FamilyModel getFamilyWithMembersById(String familyId) {
//        Optional<FamilyEntity> familyEntity = familyRepository.findFamilyWithMembersById(familyId);
//        return familyEntity.map(entity -> modelMapper.map(entity, FamilyModel.class)).orElse(null);
//    }
}
