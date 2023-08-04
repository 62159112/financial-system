package com.chongdong.financialmanagementsystem.service;

import com.chongdong.financialmanagementsystem.model.Operate;
import com.chongdong.financialmanagementsystem.model.Purchase;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;

/**
* @author cd
* @description 针对表【tcd_purchase(购置条目)】的数据库操作Service
* @createDate 2023-08-03 15:36:58
*/
public interface PurchaseService extends IService<Purchase> {
    ResponseMap addPurchase(Purchase purchase);

    ResponseMap updatePurchase(Purchase purchase);

    ResponseMap deletePurchase(Integer id);

    ResponseMap getPurchase(Integer id);

    ResponseMap listPurchase(Integer page,Integer size);

    ResponseMap searchPurchase(SearchModel searchModel);
}
