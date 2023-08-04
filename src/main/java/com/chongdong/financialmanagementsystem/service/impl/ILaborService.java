package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.factory.MapFactory;
import com.chongdong.financialmanagementsystem.model.Labor;
import com.chongdong.financialmanagementsystem.model.Pay;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.service.LaborService;
import com.chongdong.financialmanagementsystem.mapper.LaborMapper;
import com.chongdong.financialmanagementsystem.service.PayService;
import com.chongdong.financialmanagementsystem.utils.PageUtil;
import com.chongdong.financialmanagementsystem.utils.ResponseMapUtil;
import com.chongdong.financialmanagementsystem.utils.WrapperUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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
    PayService payService;

    Pay pay = MapFactory.createPay();

    @Override
    public ResponseMap addLabor(Labor labor) {
        BeanUtils.copyProperties(labor,pay);
        pay.setType("人工成本");
        payService.addPay(pay);
        return responseMapUtil.addEntity(this.save(labor));
    }

    @Override
    public ResponseMap updateLabor(Labor labor) {
        BeanUtils.copyProperties(labor,pay);
        pay.setId(null);
        pay.setType(null);
        return responseMapUtil.updateEntity(this.updateById(labor));
    }

    @Override
    public ResponseMap deleteLabor(Integer id) {
        return responseMapUtil.deleteEntity(this.removeById(id));
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
    public ResponseMap searchLabor(String search, Integer page, Integer size, String startTime, String endTime) {
        Page<Labor> pageList = this.page(pageUtil.getModelPage(page, size),wrapperUtil.wrapperNormal(search,startTime,endTime));
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }

}




