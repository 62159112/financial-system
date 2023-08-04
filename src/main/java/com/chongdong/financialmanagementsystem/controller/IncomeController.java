package com.chongdong.financialmanagementsystem.controller;

import com.chongdong.financialmanagementsystem.model.Income;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;
import com.chongdong.financialmanagementsystem.service.IncomeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/income")
public class IncomeController {
    @Resource
    IncomeService incomeService;
    @GetMapping("/{id}")
    public ResponseMap getIncome(@PathVariable Integer id){
        return incomeService.getIncome(id);
    }

    @GetMapping("/list/{page}/{size}")
    public ResponseMap listIncome(@PathVariable Integer page, @PathVariable Integer size){
        return incomeService.listIncome(page,size);
    }

    @GetMapping("/search")
    public ResponseMap searchIncome(@RequestBody SearchModel searchModel){
        return incomeService.searchIncome(searchModel);
    }
}
