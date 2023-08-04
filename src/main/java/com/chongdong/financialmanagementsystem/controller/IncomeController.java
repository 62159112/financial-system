package com.chongdong.financialmanagementsystem.controller;

import com.chongdong.financialmanagementsystem.model.Income;
import com.chongdong.financialmanagementsystem.service.IncomeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/income")
public class IncomeController {
    @Resource
    IncomeService incomeService;
    @PostMapping
    public String addIncome(@RequestBody Income income){
        System.out.println(income.toString()+"!!!!!!!!!");
        incomeService.save(income);
        return "111";
    }
}
