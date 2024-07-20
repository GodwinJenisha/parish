package com.newwayus.parishpro.service;

import com.newwayus.parishpro.entity.DailyExpenseEntity;
import com.newwayus.parishpro.model.DailyExpenseModel;
import com.newwayus.parishpro.repository.DailyExpenseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DailyExpenseService {

    @Autowired
    private DailyExpenseRepository dailyExpenseRepository;

    @Autowired
    private ModelMapper modelMapper;


    public DailyExpenseModel createDailyExpense(DailyExpenseModel dailyExpenseModel) {
        DailyExpenseEntity dailyExpenseEntity = modelMapper.map(dailyExpenseModel, DailyExpenseEntity.class);
        dailyExpenseEntity = dailyExpenseRepository.save(dailyExpenseEntity);
        return modelMapper.map(dailyExpenseEntity, DailyExpenseModel.class);
    }

    public List<DailyExpenseModel> getAllDailyExpense() {
        return dailyExpenseRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, DailyExpenseModel.class))
                .collect(Collectors.toList());
    }

    public DailyExpenseModel getDailyExpenseById(Long dailyExpenseId) {
        return dailyExpenseRepository.findById(dailyExpenseId)
                .map(entity -> modelMapper.map(entity, DailyExpenseModel.class))
                .orElse(null);
    }

    public DailyExpenseModel updateDailyExpense(Long dailyExpenseId, DailyExpenseModel dailyExpenseModel) {
        DailyExpenseEntity dailyExpenseEntity = modelMapper.map(dailyExpenseModel, DailyExpenseEntity.class);
        dailyExpenseEntity.setDailyExpenseId(dailyExpenseId);
        dailyExpenseEntity = dailyExpenseRepository.save(dailyExpenseEntity);
        return modelMapper.map(dailyExpenseEntity, DailyExpenseModel.class);

    }

    public void deleteDailyExpense(Long dailyExpenseId) {
        dailyExpenseRepository.deleteById(dailyExpenseId);
    }


}