package com.chongdong.financialmanagementsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chongdong.financialmanagementsystem.mapper")
public class FinancialManagementSystemApplication {

    public static void main(String[] args) {
        System.out.println("打发打发");
        SpringApplication.run(FinancialManagementSystemApplication.class, args);
    }

}
