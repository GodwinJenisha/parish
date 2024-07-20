package com.newwayus.parishpro.controller;

import com.newwayus.parishpro.model.MemberModel;
import com.newwayus.parishpro.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member")
@CrossOrigin(origins = "http://localhost:3030")  //added by GJ
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/add")
    public MemberModel createMember(@RequestBody MemberModel memberModel) {
        return memberService.createMember(memberModel);
    }

    @GetMapping("/list")
    public List<MemberModel> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberModel> getMemberById(@PathVariable String id) {
        MemberModel memberModel = memberService.getMemberById(id);
        return memberModel != null ? ResponseEntity.ok(memberModel) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public MemberModel updateMember(@PathVariable String id, @RequestBody MemberModel memberModel) {
        return memberService.updateMember(id, memberModel);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable String id) {
        memberService.deleteMember(id);
    }
}
