package com.newwayus.parishpro.controller;


import com.newwayus.parishpro.model.AssociationModel;
import com.newwayus.parishpro.service.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/association")
@CrossOrigin(origins = "http://localhost:3030")  //added by GJ
public class AssociationController {

    @Autowired
    private AssociationService associationService;


    @PostMapping("/add")
    public AssociationModel createAssociation(@RequestBody AssociationModel associationModel){
        return associationService.createAssociation(associationModel);
    }

    @GetMapping("/list")
    public List<AssociationModel> getAllAssociation() {

        return associationService.getAllAssociation();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssociationModel> getAssociationById(@PathVariable String id){
      AssociationModel associationModel = associationService.getAssociationById(id);
      return associationModel != null ? ResponseEntity.ok(associationModel) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public AssociationModel updateAssociation(@PathVariable String id, @RequestBody AssociationModel associationModel){
        return associationService.updateAssociation(id,associationModel);
    }

    @DeleteMapping("/{id}")
    public void deleteAssociation(@PathVariable String id){

        associationService.deleteAssociation(id);
    }



}
