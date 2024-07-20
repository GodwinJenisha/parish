package com.newwayus.parishpro.controller;

import com.newwayus.parishpro.model.ParishModel;
import com.newwayus.parishpro.service.ParishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parish")
@CrossOrigin(origins = "http://localhost:3030")
public class ParishController {

    @Autowired
    private ParishService parishService;

    @PostMapping("/add")
    public ParishModel createParish(@RequestBody ParishModel parishModel) {
        return parishService.createParish(parishModel);
    }

    @GetMapping("/list")
    public List<ParishModel> getAllParishes() {

        return parishService.getAllParishes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParishModel> getParishById(@PathVariable String id) {
        ParishModel parishModel = parishService.getParishById(id);
        return parishModel != null ? ResponseEntity.ok(parishModel) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ParishModel updateParish(@PathVariable String id, @RequestBody ParishModel parishModel) {
        return parishService.updateParish(id, parishModel);
    }

    @DeleteMapping("/{id}")
    public void deleteParish(@PathVariable String id) {

        parishService.deleteParish(id);
    }

//    @GetMapping("/with-priests/{id}")
//    public ResponseEntity<ParishModel> getParishWithPriestsById(@PathVariable String id) {
//        ParishModel parishModel = parishService.getParishWithPriestsById(id);
//        return parishModel != null ? ResponseEntity.ok(parishModel) : ResponseEntity.notFound().build();
//    }
}
