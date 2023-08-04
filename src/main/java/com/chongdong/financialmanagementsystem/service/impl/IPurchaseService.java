package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.factory.EntityFactory;
import com.chongdong.financialmanagementsystem.model.*;
import com.chongdong.financialmanagementsystem.service.PaymentService;
import com.chongdong.financialmanagementsystem.service.PurchaseService;
import com.chongdong.financialmanagementsystem.mapper.PurchaseMapper;
import com.chongdong.financialmanagementsystem.utils.PageUtil;
import com.chongdong.financialmanagementsystem.utils.ResponseMapUtil;
import com.chongdong.financialmanagementsystem.utils.WrapperUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

/**
* @author cd
* @description 针对表【tcd_purchase(购置条目)】的数据库操作Service实现
* @createDate 2023-08-03 15:36:58
*/
@Service
public class IPurchaseService extends ServiceImpl<PurchaseMapper, Purchase>
    implements PurchaseService{
    @Resource
    PageUtil<Purchase> pageUtil;
    @Resource
    WrapperUtil<Purchase> wrapperUtil;
    @Resource
    ResponseMapUtil<Purchase> responseMapUtil;
    @Resource
    PaymentService paymentService;

    Payment payment = EntityFactory.createPayment();
    //TODO 同时添加进库存管理，若有直接在已有项添加，若无则创建新项 修改判断是否有数量变化，删除直接减
    @Override
    @Transactional
    public ResponseMap addPurchase(Purchase purchase) {
        purchase.setCreateTime(new Date());
        BeanUtils.copyProperties(purchase,payment);
        payment.setType("购置成本");
        return responseMapUtil.addEntity(this.save(purchase) && paymentService.addOtherWithPayment(payment));
    }

    @Override
    @Transactional
    public ResponseMap updatePurchase(Purchase purchase) {
        BeanUtils.copyProperties(purchase,payment);
        payment.setId(null);
        payment.setType(null);
        return responseMapUtil.updateEntity(this.updateById(purchase) && paymentService.updateOtherWithPayment(payment));
    }

    @Override
    @Transactional
    public ResponseMap deletePurchase(Integer id) {
        Purchase purchase = this.getById(id);
        BeanUtils.copyProperties(purchase,payment);
        payment.setId(null);
        payment.setType(null);
        return responseMapUtil.deleteEntity(this.removeById(id) && paymentService.deleteOtherWithPayment(payment));
    }

    @Override
    public ResponseMap getPurchase(Integer id) {
        return responseMapUtil.getEntity(this.getById(id));
    }

    @Override
    public ResponseMap listPurchase(Integer page, Integer size) {
        Page<Purchase> pageList = pageUtil.getPageList(this.getBaseMapper(),pageUtil.getModelPage(page, size));
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }

    @Override
    public ResponseMap searchPurchase(SearchModel searchModel) {
        Page<Purchase> pageList = this.page(pageUtil.getModelPage(searchModel.getPage(), searchModel.getSize()),
                wrapperUtil.wrapperNormal(searchModel.getSearch(), searchModel.getStartTime(), searchModel.getEndTime()));
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }
}




