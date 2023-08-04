package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.model.Payment;
import com.chongdong.financialmanagementsystem.service.PaymentService;
import com.chongdong.financialmanagementsystem.mapper.PaymentMapper;
import com.chongdong.financialmanagementsystem.utils.ResponseMapUtil;
import com.chongdong.financialmanagementsystem.utils.WrapperUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author cd
* @description 针对表【tcd_payment(支出条目)】的数据库操作Service实现
* @createDate 2023-08-04 15:13:59
*/
@Service
public class IPaymentService extends ServiceImpl<PaymentMapper, Payment>
    implements PaymentService{
    @Resource
    ResponseMapUtil<Payment> responseMapUtil;
    @Resource
    WrapperUtil<Payment> wrapperUtil;



    @Override
    public Boolean addOtherWithPay(Payment payment) {
        return this.save(payment);
    }

    @Override
    public Boolean updateOtherWithPay(Payment payment) {
        return this.update(wrapperUtil.wrapperGetOne(payment.getName(),payment.getCreateTime()));
    }

    @Override
    public Boolean deleteOtherWithPay(Payment payment) {
        return this.remove(wrapperUtil.wrapperGetOne(payment.getName(),payment.getCreateTime()));
    }
}




