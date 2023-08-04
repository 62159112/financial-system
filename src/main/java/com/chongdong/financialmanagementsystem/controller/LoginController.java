package com.chongdong.financialmanagementsystem.controller;


import com.chongdong.financialmanagementsystem.model.Administrators;
import com.chongdong.financialmanagementsystem.service.AdministratorsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Resource
    AdministratorsService administratorsService;



}
