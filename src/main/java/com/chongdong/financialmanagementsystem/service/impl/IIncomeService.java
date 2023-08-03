package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.model.Income;
import com.chongdong.financialmanagementsystem.service.IncomeService;
import com.chongdong.financialmanagementsystem.mapper.IncomeMapper;
import org.springframework.stereotype.Service;

/**
* @author cd
* @description 针对表【tcd_income(收入条目)】的数据库操作Service实现
* @createDate 2023-08-03 14:41:11
*/
@Service
public class IIncomeService extends ServiceImpl<IncomeMapper, Income>
    implements IncomeService{

}




