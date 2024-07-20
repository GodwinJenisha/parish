package com.newwayus.parishpro.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


    @RestController
    @RequestMapping("/api/occupation")
    @CrossOrigin(origins = "http://localhost:3030")
    public class OccupationController {

        @Autowired
        private OccupationService occupationService;


        @PostMapping("/add")
        public OccupationModel createOccupation(@RequestBody OccupationModel occupationModel) {
            return occupationService.createOccupation(occupationModel);

        }


        @GetMapping("/list")
        public List<OccupationModel> getAllOccupation(){
            return occupationService.getalloccupation();
        }


        @GetMapping("/{id}")
        public ResponseEntity<OccupationModel> getOccupationById(@PathVariable String id){
            OccupationModel occupationModel = occupationService.getOccupationById(id);
            return occupationModel != null ? ResponseEntity.ok(occupationModel): ResponseEntity.notFound().build();
        }

        @PutMapping("/{id}")
        public OccupationModel updateOccupation (@PathVariable String id, @RequestBody OccupationModel occupationModel){
            return occupationService.updateOccupation(id, occupationModel);
        }

        @DeleteMapping("/{id}")
        public void deleteOccupation(@PathVariable String id){
            occupationService.deleteOccupation(id);
        }

//        @GetMapping("/getAllOccupation")
//        ResponseEntity<List<OccupationModel>> getAllOccupation() {
//            List<OccupationModel> occupationModelList = occupationService.getalloccupation();
//           return ResponseEntity.status(HttpStatus.OK).body(occupationModelList);
//       }
//
//        @GetMapping("/getOccupationName/{occupationName}")
//        ResponseEntity<List<OccupationModel>> getOccupationName(@PathVariable String occupationName) {
//            List<OccupationModel> occupationModelList = occupationService.getOccupationByName(occupationName);
//            return ResponseEntity.status(HttpStatus.OK).body(occupationModelList);
//        }
//
//
//        @PutMapping("update/{id}")
//        public OccupationModel updateoOccupation(@PathVariable String id, @RequestBody OccupationModel occupationModel) {
//            return occupationService.updateOccupation(id,occupationModel);
//        }
//        @DeleteMapping("/Delete/{id}")
//        public String deleteOccupation(@PathVariable String id) {
//            occupationService.deleteOccupation(id);
//            return "deleted succesfully";
//        }
    }
