package com.newwayus.parishpro.service;

import com.newwayus.parishpro.entity.MemberEntity;
import com.newwayus.parishpro.model.MemberModel;
import com.newwayus.parishpro.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ModelMapper modelMapper;

    public MemberModel createMember(MemberModel memberModel) {
        MemberEntity memberEntity = modelMapper.map(memberModel, MemberEntity.class);
        memberEntity = memberRepository.save(memberEntity);
        return modelMapper.map(memberEntity, MemberModel.class);
    }

    public List<MemberModel> getAllMembers() {
        return memberRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, MemberModel.class))
                .collect(Collectors.toList());
    }

    public MemberModel getMemberById(String memberId) {
        return memberRepository.findById(memberId)
                .map(entity -> modelMapper.map(entity, MemberModel.class))
                .orElse(null);
    }

    public MemberModel updateMember(String memberId, MemberModel memberModel) {
        MemberEntity memberEntity = modelMapper.map(memberModel, MemberEntity.class);
        memberEntity.setMemberId(memberId); // Ensure the ID is set for the update
        memberEntity = memberRepository.save(memberEntity);
        return modelMapper.map(memberEntity, MemberModel.class);
    }


    public void deleteMember(String memberId) {
        memberRepository.deleteById(memberId);
    }
}
