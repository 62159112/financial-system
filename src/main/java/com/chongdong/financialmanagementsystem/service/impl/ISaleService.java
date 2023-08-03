package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.model.Sale;
import com.chongdong.financialmanagementsystem.service.SaleService;
import com.chongdong.financialmanagementsystem.mapper.SaleMapper;
import org.springframework.stereotype.Service;

/**
* @author cd
* @description 针对表【tcd_sale(销售出账条目)】的数据库操作Service实现
* @createDate 2023-08-03 15:37:03
*/
@Service
public class ISaleService extends ServiceImpl<SaleMapper, Sale>
    implements SaleService{

}




