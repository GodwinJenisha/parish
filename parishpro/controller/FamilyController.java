package com.newwayus.parishpro.controller;

import com.newwayus.parishpro.model.FamilyModel;
import com.newwayus.parishpro.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/family")
@CrossOrigin(origins = "http://localhost:3030")  //added by GJ
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    @PostMapping("/add")
    public FamilyModel createFamily(@RequestBody FamilyModel familyModel) {
        return familyService.createFamily(familyModel);
    }

    @GetMapping("/list")
    public List<FamilyModel> getAllFamilies(){

        return familyService.getAllFamilies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FamilyModel> getFamilyById(@PathVariable String id){
        FamilyModel familyModel = familyService.getFamilyById(id);
        return familyModel !=null ? ResponseEntity.ok(familyModel): ResponseEntity.notFound().build();
    }


    @PutMapping("/{id}")
    public FamilyModel updateFamily(@PathVariable String id, @RequestBody FamilyModel familyModel){
        return familyService.updateFamily(id, familyModel);
    }

    @DeleteMapping("/{id}")
    public void deleteFamily(@PathVariable String id){

        familyService.deleteFamily(id);
    }



//    @PostMapping("/add")
//    public FamilyModel createFamily(@RequestBody FamilyModel familyModel) {
//        return familyService.createFamily(familyModel);
//    }
//
//    @GetMapping("/list")
//    public List<FamilyModel> getAllFamilies() {
//        return familyService.getAllFamilies();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<FamilyModel> getFamilyById(@PathVariable String id) {
//        FamilyModel familyModel = familyService.getFamilyById(id);
//        return familyModel != null ? ResponseEntity.ok(familyModel) : ResponseEntity.notFound().build();
//    }
//
//    @GetMapping("/members/{id}")
//    public ResponseEntity<FamilyModel> getFamilyWithMembersById(@PathVariable String id) {
//        FamilyModel familyModel = familyService.getFamilyWithMembersById(id);
//        return familyModel != null ? ResponseEntity.ok(familyModel) : ResponseEntity.notFound().build();
//    }
//
//    @PutMapping("/{id}")
//    public FamilyModel updateFamily(@PathVariable String id, @RequestBody FamilyModel familyModel) {
//        return familyService.updateFamily(id, familyModel);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteFamily(@PathVariable String id) {
//        familyService.deleteFamily(id);
//    }
}
