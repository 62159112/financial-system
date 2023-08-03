package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.model.Inventory;
import com.chongdong.financialmanagementsystem.service.InventoryService;
import com.chongdong.financialmanagementsystem.mapper.InventoryMapper;
import org.springframework.stereotype.Service;

/**
* @author cd
* @description 针对表【tcd_inventory(库存条目)】的数据库操作Service实现
* @createDate 2023-08-03 15:36:33
*/
@Service
public class IInventoryService extends ServiceImpl<InventoryMapper, Inventory>
    implements InventoryService{

}




