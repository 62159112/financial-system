package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.model.Pay;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.service.PayService;
import com.chongdong.financialmanagementsystem.mapper.PayMapper;
import com.chongdong.financialmanagementsystem.utils.ResponseMapUtil;
import com.chongdong.financialmanagementsystem.utils.WrapperUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author cd
* @description 针对表【tcd_pay(支出条目)】的数据库操作Service实现
* @createDate 2023-08-03 15:36:16
*/
@Service
public class IPayService extends ServiceImpl<PayMapper, Pay>
    implements PayService{
    @Resource
    ResponseMapUtil<Pay> responseMapUtil;
    @Resource
    WrapperUtil<Pay> wrapperUtil;



    @Override
    public Boolean addOtherWithPay(Pay pay) {
        return this.save(pay);
    }

    @Override
    public Boolean updateOtherWithPay(Pay pay) {
        return this.update(wrapperUtil.wrapperGetOne(pay.getName(),pay.getCreateTime()));
    }

    @Override
    public Boolean deleteOtherWithPay(Pay pay) {
        return this.remove(wrapperUtil.wrapperGetOne(pay.getName(),pay.getCreateTime()));
    }
}




