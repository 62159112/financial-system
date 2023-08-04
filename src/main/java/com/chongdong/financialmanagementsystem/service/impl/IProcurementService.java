package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.model.Procurement;
import com.chongdong.financialmanagementsystem.service.InventoryService;
import com.chongdong.financialmanagementsystem.service.ProcurementService;
import com.chongdong.financialmanagementsystem.mapper.ProcurementMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author cd
* @description 针对表【tcd_procurement(采购条目)】的数据库操作Service实现
* @createDate 2023-08-03 15:36:56
*/
@Service
public class IProcurementService extends ServiceImpl<ProcurementMapper, Procurement>
    implements ProcurementService{

    @Resource
    InventoryService inventoryService;
}




