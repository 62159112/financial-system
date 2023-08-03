package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.model.Purchase;
import com.chongdong.financialmanagementsystem.service.PurchaseService;
import com.chongdong.financialmanagementsystem.mapper.PurchaseMapper;
import org.springframework.stereotype.Service;

/**
* @author cd
* @description 针对表【tcd_purchase(购置条目)】的数据库操作Service实现
* @createDate 2023-08-03 15:36:58
*/
@Service
public class IPurchaseService extends ServiceImpl<PurchaseMapper, Purchase>
    implements PurchaseService{

}




