package com.newwayus.parishpro.service;


import com.newwayus.parishpro.entity.MemberEntity;
import com.newwayus.parishpro.model.MemberModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NonMemberService {

    @Autowired
    private NonMemberRepository nonMemberRepository;

    @Autowired
    private ModelMapper modelMapper;

    public NonMemberModel createNonMember(NonMemberModel nonMemberModel) {
        NonMemberEntity nonMemberEntity = modelMapper.map(nonMemberModel, NonMemberEntity.class);
        nonMemberEntity = nonMemberRepository.save(nonMemberEntity);
        return modelMapper.map(nonMemberEntity, NonMemberModel.class);
    }

    public List<NonMemberModel> getAllNonMember() {
        return nonMemberRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, NonMemberModel.class))
                .collect(Collectors.toList());
    }

    public NonMemberModel getNonMemberById(String nonMemberId) {
        return nonMemberRepository.findById(nonMemberId)
                .map(entity -> modelMapper.map(entity, NonMemberModel.class))
                .orElse(null);
    }

    public NonMemberModel updateNonMember(String nonMemberId, NonMemberModel nonMemberModel) {
        NonMemberEntity nonMemberEntity = modelMapper.map(nonMemberModel, NonMemberEntity.class);
        nonMemberEntity.setNonMemberId(nonMemberId); // Ensure the ID is set for the update
        nonMemberEntity = nonMemberRepository.save(nonMemberEntity);
        return modelMapper.map(nonMemberEntity, NonMemberModel.class);
    }


    public void deleteNonMember(String nonMemberId) {
        nonMemberRepository.deleteById(nonMemberId);
    }
}

