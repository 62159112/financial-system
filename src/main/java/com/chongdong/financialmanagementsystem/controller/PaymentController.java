package com.chongdong.financialmanagementsystem.controller;

import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;
import com.chongdong.financialmanagementsystem.service.PaymentService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    PaymentService paymentService;

    @GetMapping("/{id}")
    public ResponseMap getPayment(@PathVariable Integer id){
        return paymentService.getPayment(id);
    }
    
    @GetMapping("/list/{page}/{size}")
    public ResponseMap listPayment(@PathVariable Integer page, @PathVariable Integer size){
        return paymentService.listPayment(page,size);
    }

    @GetMapping("/search")
    public ResponseMap searchPayment(@RequestBody SearchModel searchModel){
        return paymentService.searchPayment(searchModel);
    }
}
