package com.newwayus.parishpro.service;


import com.newwayus.parishpro.entity.BillEntity;
import com.newwayus.parishpro.entity.DailyExpenseEntity;
import com.newwayus.parishpro.model.BillModel;
import com.newwayus.parishpro.model.DailyExpenseModel;
import com.newwayus.parishpro.repository.BillRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    public BillModel createBill(BillModel billModel){
        BillEntity billEntity =  modelMapper.map(billModel, BillEntity.class);
        billEntity = billRepository.save(billEntity);
        return modelMapper.map(billEntity,BillModel.class);
    }

    public List<BillModel> getAllBill() {
        return billRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, BillModel.class))
                .collect(Collectors.toList());
    }

    public BillModel getBillById(Long billId) {
        return billRepository.findById(billId)
                .map(entity -> modelMapper.map(entity, BillModel.class))
                .orElse(null);
    }

    public BillModel updateBill(Long billId, BillModel billModel) {
        BillEntity billEntity = modelMapper.map(billModel, BillEntity.class);
        billEntity.setBillId(billId);
        billEntity = billRepository.save(billEntity);
        return modelMapper.map(billEntity, BillModel.class);

    }

    public void deleteBill(Long billId) {
        billRepository.deleteById(billId);
    }


}

