package com.newwayus.parishpro.controller;


import com.newwayus.parishpro.model.AuditoriumModel;
import com.newwayus.parishpro.service.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auditorium")
@CrossOrigin(origins = "http://localhost:3030")
public class AuditoriumController {

    @Autowired
    private AuditoriumService auditoriumService;

    @PostMapping("/add")
    public AuditoriumModel createAuditorium(@RequestBody AuditoriumModel auditoriumModel){
        return auditoriumService.createAuditorium(auditoriumModel);
    }

    @GetMapping("/list")
    public List<AuditoriumModel> getAllAuditorium(){
        return auditoriumService.getAllAuditorium();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditoriumModel> getAuditoriumById(@PathVariable Long id){
        AuditoriumModel auditoriumModel = auditoriumService.getAuditoriumById(id);
        return auditoriumModel != null ? ResponseEntity.ok(auditoriumModel) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuditoriumModel> updateAuditorium(@PathVariable Long id, @RequestBody AuditoriumModel updatedAuditorium){
        AuditoriumModel updatedAuditoriums = auditoriumService.updateAuditorium(id,updatedAuditorium);
        return updatedAuditoriums != null ? ResponseEntity.ok(updatedAuditorium): ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deleteAuditorium(@PathVariable Long id){
        auditoriumService.deleteAuditorium(id);
    }
}
