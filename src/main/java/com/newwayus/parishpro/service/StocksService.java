package com.newwayus.parishpro.service;

import com.newwayus.parishpro.entity.StocksEntity;
import com.newwayus.parishpro.model.StocksModel;
import com.newwayus.parishpro.repository.StocksRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StocksService {

    @Autowired
    private StocksRepository stocksRepository;

    @Autowired
    private ModelMapper modelMapper;

    public StocksModel createStock(StocksModel stocksModel) {
        StocksEntity stocksEntity = modelMapper.map(stocksModel, StocksEntity.class);
        stocksEntity = stocksRepository.save(stocksEntity);
        return modelMapper.map(stocksEntity, StocksModel.class);
    }

    public List<StocksModel> getAllStocks() {
        return stocksRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, StocksModel.class))
                .collect(Collectors.toList());
    }

    public StocksModel getStockById(int id) {
        return stocksRepository.findById(id)
                .map(entity -> modelMapper.map(entity, StocksModel.class))
                .orElse(null);
    }

    public StocksModel updateStock(int id, StocksModel stocksModel) {
        StocksEntity stocksEntity = modelMapper.map(stocksModel, StocksEntity.class);
        stocksEntity.setId(id);
        stocksEntity = stocksRepository.save(stocksEntity);
        return modelMapper.map(stocksEntity, StocksModel.class);
    }

    public void deleteStock(int id) {
        stocksRepository.deleteById(id);
    }
}
