package com.newwayus.parishpro.service;

import com.newwayus.parishpro.entity.AnbiyamEntity;
import com.newwayus.parishpro.entity.MemberEntity;
import com.newwayus.parishpro.entity.ParishEntity;
import com.newwayus.parishpro.model.AnbiyamModel;
import com.newwayus.parishpro.model.MemberModel;
import com.newwayus.parishpro.model.ParishModel;
import com.newwayus.parishpro.repository.AnbiyamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private ModelMapper modelMapper;

    public AnbiyamModel createAnbiyam(AnbiyamModel anbiyamModel) {
        AnbiyamEntity anbiyamEntity = modelMapper.map(anbiyamModel, AnbiyamEntity.class);
        anbiyamEntity = anbiyamRepository.save(anbiyamEntity);
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

    public AnbiyamModel updateAnbiyam(String id, AnbiyamModel anbiyamModel) {
        AnbiyamEntity anbiyamEntity = modelMapper.map(anbiyamModel, AnbiyamEntity.class);
        anbiyamEntity.setAnbiyamId(id); // Ensure ID is set for the update
        anbiyamEntity = anbiyamRepository.save(anbiyamEntity);
        return modelMapper.map(anbiyamEntity, AnbiyamModel.class);
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
