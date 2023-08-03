package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.model.Pay;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.service.PayService;
import com.chongdong.financialmanagementsystem.mapper.PayMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
* @author cd
* @description 针对表【tcd_pay(支出条目)】的数据库操作Service实现
* @createDate 2023-08-03 15:36:16
*/
@Service
public class IPayService extends ServiceImpl<PayMapper, Pay>
    implements PayService{
    @Override
    public ResponseMap addPay(Pay pay) {
        BeanUtils.copyProperties(pay,pay);
        return null;
    }
}




