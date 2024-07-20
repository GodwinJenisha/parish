package com.newwayus.parishpro.service;

import com.newwayus.parishpro.entity.DailyScheduleEntity;
import com.newwayus.parishpro.model.DailyScheduleModel;
import com.newwayus.parishpro.repository.DailyScheduleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DailyScheduleService {

    @Autowired
    private DailyScheduleRepository dailyScheduleRepository;

    @Autowired
    private ModelMapper modelMapper;


    public DailyScheduleModel createDailySchedule(DailyScheduleModel dailyScheduleModel){
        DailyScheduleEntity dailyScheduleEntity = modelMapper.map(dailyScheduleModel, DailyScheduleEntity.class);
        dailyScheduleEntity = dailyScheduleRepository.save(dailyScheduleEntity);
        return modelMapper.map(dailyScheduleEntity, DailyScheduleModel.class);
    }

    public List<DailyScheduleModel> getAllDailySchedule(){
        return dailyScheduleRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, DailyScheduleModel.class))
                .collect(Collectors.toList());
    }

    public DailyScheduleModel getDailyScheduleById(int dailyScheduleId){
        return dailyScheduleRepository.findById(dailyScheduleId)
                .map(entity -> modelMapper.map(entity, DailyScheduleModel.class))
                .orElse(null);
    }

    public DailyScheduleModel updateDailySchedule(int dailyScheduleId, DailyScheduleModel dailyScheduleModel) {
        DailyScheduleEntity dailyScheduleEntity = modelMapper.map(dailyScheduleModel, DailyScheduleEntity.class);
        dailyScheduleEntity.setDailyScheduleId(dailyScheduleId);
        dailyScheduleEntity = dailyScheduleRepository.save(dailyScheduleEntity);
        return modelMapper.map(dailyScheduleEntity, DailyScheduleModel.class);

    }

    public void deleteDailySchedule(int dailyScheduleId) {
        dailyScheduleRepository.deleteById(dailyScheduleId);
    }
}
