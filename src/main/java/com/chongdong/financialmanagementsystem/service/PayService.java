package com.chongdong.financialmanagementsystem.service;

import com.chongdong.financialmanagementsystem.model.Pay;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chongdong.financialmanagementsystem.model.ResponseMap;

/**
* @author cd
* @description 针对表【tcd_pay(支出条目)】的数据库操作Service
* @createDate 2023-08-03 15:36:16
*/
public interface PayService extends IService<Pay> {
    Boolean addOtherWithPay(Pay pay);

    Boolean updateOtherWithPay(Pay pay);

    Boolean deleteOtherWithPay(Pay pay);
}
