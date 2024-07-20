package com.newwayus.parishpro.controller;

import com.newwayus.parishpro.model.AnbiyamModel;
import com.newwayus.parishpro.service.AnbiyamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/anbiyam")
@CrossOrigin(origins = "http://localhost:3030")  //added by GJ
public class AnbiyamController {

    @Autowired
    private AnbiyamService anbiyamService;

    @PostMapping("/add")
    public AnbiyamModel createAnbiyam(@RequestBody AnbiyamModel anbiyamModel) {
        return anbiyamService.createAnbiyam(anbiyamModel);
    }

    @GetMapping("/list")
    public List<AnbiyamModel> getAllAnbiyams() {

        return anbiyamService.getAllAnbiyams();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnbiyamModel> getAnbiyamById(@PathVariable String id) {
        AnbiyamModel anbiyamModel = anbiyamService.getAnbiyamById(id);
        return anbiyamModel != null ? ResponseEntity.ok(anbiyamModel) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public AnbiyamModel updateAnbiyam(@PathVariable String id, @RequestBody AnbiyamModel anbiyamModel) {
        return anbiyamService.updateAnbiyam(id, anbiyamModel);
    }

    @DeleteMapping("/{id}")
    public void deleteAnbiyam(@PathVariable String id) {

        anbiyamService.deleteAnbiyam(id);
    }
}
