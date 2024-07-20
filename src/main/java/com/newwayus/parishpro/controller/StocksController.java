package com.newwayus.parishpro.controller;

import com.newwayus.parishpro.model.StocksModel;
import com.newwayus.parishpro.service.StocksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@CrossOrigin(origins = "http://localhost:3030")
public class StocksController {

    @Autowired
    private StocksService stocksService;

    @PostMapping("/add")
    public StocksModel createStock(@RequestBody StocksModel stocksModel) {
        return stocksService.createStock(stocksModel);
    }

    @GetMapping("/list")
    public List<StocksModel> getAllStocks() {
        return stocksService.getAllStocks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StocksModel> getStockById(@PathVariable int id) {
        StocksModel stocksModel = stocksService.getStockById(id);
        return stocksModel != null ? ResponseEntity.ok(stocksModel) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StocksModel> updateStock(@PathVariable int id, @RequestBody StocksModel updatedStocksModel) {
        StocksModel updatedStock = stocksService.updateStock(id, updatedStocksModel);
        return updatedStock != null ? ResponseEntity.ok(updatedStock) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable int id) {
        stocksService.deleteStock(id);
    }
}
