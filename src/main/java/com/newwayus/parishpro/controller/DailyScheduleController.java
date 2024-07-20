package com.newwayus.parishpro.controller;


import com.newwayus.parishpro.model.DailyScheduleModel;
import com.newwayus.parishpro.service.DailyScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dailySchedule")
@CrossOrigin(origins = "http://localhost:3030")
public class DailyScheduleController {

    @Autowired
    private DailyScheduleService dailyScheduleService;


    @PostMapping("/add")
    public DailyScheduleModel createDailySchedule(@RequestBody DailyScheduleModel dailyScheduleModel){
        return dailyScheduleService.createDailySchedule(dailyScheduleModel);
    }

    @GetMapping("/list")
    public List<DailyScheduleModel> getAllDailySchedule(){
        return dailyScheduleService.getAllDailySchedule();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DailyScheduleModel>  getDailyScheduleById(@PathVariable int id){
        DailyScheduleModel dailyScheduleModel = dailyScheduleService.getDailyScheduleById(id);
        return dailyScheduleModel != null ? ResponseEntity.ok(dailyScheduleModel) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DailyScheduleModel> updateDailySchedule(@PathVariable int id, @RequestBody DailyScheduleModel updatedDailySchedule){
        DailyScheduleModel updatedDailySchedules = dailyScheduleService.updateDailySchedule(id, updatedDailySchedule);
        return updatedDailySchedules != null ? ResponseEntity.ok(updatedDailySchedule) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deleteDailySchedule(@PathVariable int id){
        dailyScheduleService.deleteDailySchedule(id);
    }
}
