package com.chongdong.financialmanagementsystem.controller;


import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;
import com.chongdong.financialmanagementsystem.service.InventoryService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Resource
    InventoryService inventoryService;

    @GetMapping("/list/{page}/{size}")
    public ResponseMap listLabor(@PathVariable Integer page, @PathVariable Integer size){
        return inventoryService.listInventory(page,size);
    }

    @GetMapping("/search")
    public ResponseMap searchLabor(@RequestBody SearchModel searchModel){
        return inventoryService.searchInventory(searchModel);
    }


}
