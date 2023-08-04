package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.model.Operate;
import com.chongdong.financialmanagementsystem.model.Payment;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;
import com.chongdong.financialmanagementsystem.service.PaymentService;
import com.chongdong.financialmanagementsystem.mapper.PaymentMapper;
import com.chongdong.financialmanagementsystem.utils.PageUtil;
import com.chongdong.financialmanagementsystem.utils.ResponseMapUtil;
import com.chongdong.financialmanagementsystem.utils.WrapperUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;

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
    @Resource
    PageUtil<Payment> pageUtil;



    @Override
    public Boolean addOtherWithPayment(Payment payment) {
        return this.save(payment);
    }

    @Override
    public Boolean updateOtherWithPayment(Payment payment) {
        return this.update(wrapperUtil.wrapperGetOne(payment.getName(),payment.getCreateTime()));
    }

    @Override
    public Boolean deleteOtherWithPayment(Payment payment) {
        return this.remove(wrapperUtil.wrapperGetOne(payment.getName(),payment.getCreateTime()));
    }

    @Override
    public ResponseMap addPayment(Payment payment) {
        return responseMapUtil.addEntity(this.save(payment));
    }

    @Override
    public ResponseMap updatePayment(Payment payment) {
        return responseMapUtil.updateEntity(this.updateById(payment));
    }

    @Override
    public ResponseMap deletePayment(Integer id) {
        return responseMapUtil.deleteEntity(this.removeById(id));
    }

    @Override
    public ResponseMap getPayment(Integer id) {
        return responseMapUtil.getEntity(this.getById(id));
    }

    @Override
    public ResponseMap listPayment(Integer page, Integer size) {
        Page<Payment> pageList = pageUtil.getPageList(this.getBaseMapper(),pageUtil.getModelPage(page, size));
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }

    @Override
    public ResponseMap searchPayment(SearchModel searchModel) {
        Page<Payment> pageList = this.page(pageUtil.getModelPage(searchModel.getPage(), searchModel.getSize()),
                wrapperUtil.wrapperNormal(searchModel.getSearch(), searchModel.getStartTime(), searchModel.getEndTime()));
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }
}




