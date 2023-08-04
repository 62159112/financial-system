package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.factory.EntityFactory;
import com.chongdong.financialmanagementsystem.model.*;
import com.chongdong.financialmanagementsystem.service.LaborService;
import com.chongdong.financialmanagementsystem.mapper.LaborMapper;
import com.chongdong.financialmanagementsystem.service.PaymentService;
import com.chongdong.financialmanagementsystem.utils.PageUtil;
import com.chongdong.financialmanagementsystem.utils.ResponseMapUtil;
import com.chongdong.financialmanagementsystem.utils.WrapperUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @author cd
 * @description 针对表【tcd_labor(人工成本条目)】的数据库操作Service实现
 * @createDate 2023-08-03 15:36:49
 */
@Service
public class ILaborService extends ServiceImpl<LaborMapper, Labor>
        implements LaborService {
    @Resource
    PageUtil<Labor> pageUtil;
    @Resource
    WrapperUtil<Labor> wrapperUtil;
    @Resource
    ResponseMapUtil<Labor> responseMapUtil;
    @Resource
    PaymentService paymentService;

    Payment payment = EntityFactory.createPayment();

    @Override
    public ResponseMap addLabor(Labor labor) {
        labor.setCreateTime(new Date());
        BeanUtils.copyProperties(labor,payment);
        payment.setType("人工成本");
        return responseMapUtil.addEntity(this.save(labor) && paymentService.addOtherWithPay(payment));
    }

    @Override
    public ResponseMap updateLabor(Labor labor) {
        BeanUtils.copyProperties(labor,payment);
        payment.setId(null);
        payment.setType(null);
        return responseMapUtil.updateEntity(this.updateById(labor) && paymentService.updateOtherWithPay(payment));
    }

    @Override
    public ResponseMap deleteLabor(Integer id) {
        Labor labor = this.getById(id);
        BeanUtils.copyProperties(labor,payment);
        payment.setId(null);
        payment.setType(null);
        return responseMapUtil.deleteEntity(this.removeById(id) && paymentService.deleteOtherWithPay(payment));
    }

    @Override
    public ResponseMap getLabor(Integer id) {
        return responseMapUtil.getEntity(this.getById(id));
    }

    @Override
    public ResponseMap listLabor(Integer page, Integer size) {
        Page<Labor> pageList = pageUtil.getPageList(this.getBaseMapper(),pageUtil.getModelPage(page, size));
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }

    @Override
    public ResponseMap searchLabor(SearchModel searchModel) {
        Page<Labor> pageList = this.page(pageUtil.getModelPage(searchModel.getPage(), searchModel.getSize()),
                wrapperUtil.wrapperNormal(searchModel.getSearch(), searchModel.getStartTime(), searchModel.getEndTime()));
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }

}




