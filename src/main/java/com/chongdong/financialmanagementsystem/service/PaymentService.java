package com.chongdong.financialmanagementsystem.service;

import com.chongdong.financialmanagementsystem.model.Payment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author cd
* @description 针对表【tcd_payment(支出条目)】的数据库操作Service
* @createDate 2023-08-04 15:13:59
*/
public interface PaymentService extends IService<Payment> {
    Boolean addOtherWithPay(Payment payment);

    Boolean updateOtherWithPay(Payment payment);

    Boolean deleteOtherWithPay(Payment payment);
}
