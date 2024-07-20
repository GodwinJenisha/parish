package com.newwayus.parishpro.controller;

import com.newwayus.parishpro.entity.DailyExpenseEntity;
import com.newwayus.parishpro.model.DailyExpenseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.newwayus.parishpro.service.DailyExpenseService; // Example import statement


import java.util.List;
@RestController
@RequestMapping("/api/daily-expenses")
@CrossOrigin(origins = "http://localhost:3030")
public class DailyExpenseController {

    @Autowired
    private DailyExpenseService dailyExpenseService;



    @PostMapping("/add")
    public DailyExpenseModel createDailyExpense(@RequestBody DailyExpenseModel dailyExpenseModel){
        return  dailyExpenseService.createDailyExpense(dailyExpenseModel);
    }

    @GetMapping("/list")
    public List<DailyExpenseModel> getAllDailyExpense() {

        return dailyExpenseService.getAllDailyExpense();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DailyExpenseModel> getDailyExpenseById(@PathVariable Long id) {
        DailyExpenseModel dailyExpenseModel = dailyExpenseService.getDailyExpenseById(id);
        return dailyExpenseModel != null ? ResponseEntity.ok(dailyExpenseModel) : ResponseEntity.notFound().build();
    }



    @PutMapping("/{id}")
    public ResponseEntity<DailyExpenseModel> updateDailyExpense(@PathVariable long id, @RequestBody DailyExpenseModel updatedExpense) {
        DailyExpenseModel updatedDailyExpense = dailyExpenseService.updateDailyExpense(id, updatedExpense);
        return updatedDailyExpense != null ? ResponseEntity.ok(updatedDailyExpense) : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public void deleteDailyExpense(@PathVariable Long id) {
        dailyExpenseService.deleteDailyExpense(id);

    }
}

