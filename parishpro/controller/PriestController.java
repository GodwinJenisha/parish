package com.newwayus.parishpro.controller;


import com.newwayus.parishpro.entity.PriestEntity;
import com.newwayus.parishpro.model.AnbiyamModel;
import com.newwayus.parishpro.model.ParishModel;
import com.newwayus.parishpro.model.PriestModel;
import com.newwayus.parishpro.repository.PriestRepository;
import com.newwayus.parishpro.service.PriestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/Priest")
@CrossOrigin(origins = "http://localhost:3030")
public class PriestController {
    @Autowired
    PriestService priestService;
//    @Autowired
//    PriestRepository priestRepository;

    @PostMapping("/add")
    public PriestModel createPriest(@RequestBody PriestModel priestModel){
        return priestService.createPriest(priestModel);
    }

    @GetMapping("/list")
    public List<PriestModel> getAllPriest(){
        return priestService.getAllPriest();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PriestModel> getPriestById (@PathVariable String id){
        PriestModel priestModel = priestService.getPriestById(id);
        return  priestModel != null ? ResponseEntity.ok(priestModel): ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public PriestModel updatePriest(@PathVariable String id, @RequestBody PriestModel priestModel){
        return priestService.updatePriest(id, priestModel);
    }

    @DeleteMapping("/{id}")
    public void deletePriest(@PathVariable String id){
        priestService.deletePriest(id);
    }

//    @PostMapping("/add")
//      public ResponseEntity<String> createPriest(@RequestBody PriestModel priestModel) {
//        priestService.createPriest(priestModel);
//        return ResponseEntity.status(HttpStatus.OK).body("post sucessfully");
//    }
//    @GetMapping("/getAllPriest")
//    ResponseEntity<List<PriestModel>>getAllPriest(){
//        List<PriestModel>priestModelList=priestService.getAllPriest();
//        return ResponseEntity.status(HttpStatus.OK).body(priestModelList);
//    }
//    @DeleteMapping("/delete/{priestId}")
//    public ResponseEntity<String> deletePriest(@PathVariable String priestId) {
//        priestService.deletepriest(priestId);
//        return ResponseEntity.status(HttpStatus.OK).body(" deleted successfully!");
//    }
//    @PutMapping("/{id}")
//    public PriestModel updatePriest(@PathVariable String id, @RequestBody PriestModel PriestModel) {
//        return priestService.updatePriest(id,PriestModel);
//    }
//    @GetMapping("/get/{priestId}")
//    public ResponseEntity<?> getPriestById(@PathVariable String priestId) {
//        PriestModel priestModel = priestService.getPriestById(priestId);
//        return ResponseEntity.status(HttpStatus.OK).body(priestModel);
//    }
//    @GetMapping("/getPriestName/{priestfirstName}")
//    ResponseEntity<List<PriestModel>> getPriestName(@PathVariable("priestfirstName") String priestfirstName) {
//        List<PriestModel> priestModelList = priestService.getPriestByfirstName(priestfirstName);
//        return ResponseEntity.status(HttpStatus.OK).body(priestModelList);
//    }
    }







