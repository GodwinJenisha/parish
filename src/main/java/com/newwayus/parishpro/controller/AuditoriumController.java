package com.newwayus.parishpro.controller;


import com.newwayus.parishpro.model.AuditoriumModel;
import com.newwayus.parishpro.service.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

//    @GetMapping("/events")
//    public ResponseEntity<List<AuditoriumModel>> fetchEventsForDate(@RequestParam("date") String date) {
//        try {
//            // Convert the string date to LocalDate
//            LocalDate eventDate = LocalDate.parse(date);
//
//            // Call the service to fetch events for the specified date
//            List<AuditoriumModel> events = auditoriumService.getEventsForDate(eventDate);
//
//            return ResponseEntity.ok(events);
//        } catch (Exception e) {
//            System.err.println("Error fetching events for date: " + e.getMessage());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
}
