package com.newwayus.parishpro.controller;


import com.newwayus.parishpro.model.BillModel;
import com.newwayus.parishpro.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bill")
@CrossOrigin(origins = "http://localhost:3030")
public class BillController {


    @Autowired
    private BillService billService;

    @PostMapping("/add")
    public BillModel createBill(@RequestBody BillModel billModel){

        return  billService.createBill(billModel);
    }


    @GetMapping("/list")
    public List<BillModel> getAllBill(){

        return billService.getAllBill();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillModel> getBillById(@PathVariable Long id){
        BillModel billModel = billService.getBillById(id);
        return  billModel != null ? ResponseEntity.ok(billModel) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillModel> updateBill(@PathVariable Long id, @RequestBody BillModel updatedBill){
        BillModel updatedBills = billService.updateBill(id, updatedBill);
        return updatedBills != null ? ResponseEntity.ok(updatedBill): ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deleteBill(@PathVariable Long id){
        billService.deleteBill(id);
    }
}
