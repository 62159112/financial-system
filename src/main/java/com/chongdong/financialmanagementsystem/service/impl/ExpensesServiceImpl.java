package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.model.Expenses;
import com.chongdong.financialmanagementsystem.service.ExpensesService;
import com.chongdong.financialmanagementsystem.mapper.ExpensesMapper;
import org.springframework.stereotype.Service;

/**
* @author cd
* @description 针对表【tcd_expenses(费用支出条目)】的数据库操作Service实现
* @createDate 2023-08-03 17:04:45
*/
@Service
public class ExpensesServiceImpl extends ServiceImpl<ExpensesMapper, Expenses>
    implements ExpensesService{

}




