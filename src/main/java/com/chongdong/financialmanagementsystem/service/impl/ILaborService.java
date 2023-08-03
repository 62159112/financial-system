package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.model.Labor;
import com.chongdong.financialmanagementsystem.service.LaborService;
import com.chongdong.financialmanagementsystem.mapper.LaborMapper;
import org.springframework.stereotype.Service;

/**
* @author cd
* @description 针对表【tcd_labor(人工成本条目)】的数据库操作Service实现
* @createDate 2023-08-03 15:36:49
*/
@Service
public class ILaborService extends ServiceImpl<LaborMapper, Labor>
    implements LaborService{

}




