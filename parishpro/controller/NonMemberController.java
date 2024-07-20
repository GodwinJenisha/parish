package com.newwayus.parishpro.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nonMember")
@CrossOrigin(origins = "http://localhost:3030")
public class NonMemberController {


    @Autowired
    private NonMemberService nonMemberService;


    @PostMapping("/add")
    public NonMemberModel createNonMember(@RequestBody NonMemberModel nonMemberModel){
        return nonMemberService.createNonMember(nonMemberModel);
    }

    @GetMapping("/List")
    public List<NonMemberModel> getAllNonMember(){
        return nonMemberService.getAllNonMember();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NonMemberModel> getNonMemberById(@PathVariable String id){
        NonMemberModel nonMemberModel = nonMemberService.getNonMemberById(id);
        return nonMemberModel !=null ? ResponseEntity.ok(nonMemberModel) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public NonMemberModel updateNonMember(@PathVariable String id, @RequestBody NonMemberModel nonMemberModel){
        return nonMemberService.updateNonMember(id, nonMemberModel);
    }

    @DeleteMapping("/{id}")
    public void deleteNonMember(@PathVariable String id){
        nonMemberService.deleteNonMember(id);
    }


}
