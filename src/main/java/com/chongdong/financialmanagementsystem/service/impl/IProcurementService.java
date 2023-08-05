package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.factory.EntityFactory;
import com.chongdong.financialmanagementsystem.model.*;
import com.chongdong.financialmanagementsystem.service.InventoryService;
import com.chongdong.financialmanagementsystem.service.PaymentService;
import com.chongdong.financialmanagementsystem.service.ProcurementService;
import com.chongdong.financialmanagementsystem.mapper.ProcurementMapper;
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
* @description 针对表【tcd_procurement(采购条目)】的数据库操作Service实现
* @createDate 2023-08-03 15:36:56
*/
@Service
public class IProcurementService extends ServiceImpl<ProcurementMapper, Procurement>
    implements ProcurementService{
    @Resource
    PageUtil<Procurement> pageUtil;
    @Resource
    WrapperUtil<Procurement> wrapperUtil;
    @Resource
    ResponseMapUtil<Procurement> responseMapUtil;
    @Resource
    PaymentService paymentService;
    @Resource
    InventoryService inventoryService;

    Payment payment = EntityFactory.createPayment();

    Inventory inventory = EntityFactory.createInventory();
    @Override
    @Transactional
    public ResponseMap addProcurement(Procurement procurement) {
        procurement.setCreateTime(new Date());
        BeanUtils.copyProperties(procurement,payment);
        BeanUtils.copyProperties(procurement,inventory);
        payment.setType("采购成本");
        inventory.setTotal(procurement.getQuantity());
        return responseMapUtil.addEntity(this.save(procurement) && paymentService.addOtherWithPayment(payment)
                && inventoryService.addOtherWithInventory(inventory));
    }

    @Override
    @Transactional
    public ResponseMap updateProcurement(Procurement procurement) {
        Procurement oldProcurement = this.getById(procurement.getId());
        BeanUtils.copyProperties(procurement,payment);
        payment.setId(null);
        payment.setType(null);
        BeanUtils.copyProperties(procurement,inventory);
        inventory.setTotal(procurement.getQuantity() - oldProcurement.getQuantity());
        return responseMapUtil.updateEntity(this.updateById(procurement) && paymentService.updateOtherWithPayment(payment)
                && inventoryService.UpdateOtherWithInventory(inventory));
    }

    @Override
    @Transactional
    public ResponseMap deleteProcurement(Integer id) {
        Procurement procurement = this.getById(id);
        BeanUtils.copyProperties(procurement,payment);
        payment.setId(null);
        payment.setType(null);
        BeanUtils.copyProperties(procurement,inventory);
        inventory.setTotal(procurement.getQuantity());
        return responseMapUtil.deleteEntity(this.removeById(id) && paymentService.deleteOtherWithPayment(payment)
                && inventoryService.deleteOtherWithInventory(inventory));
    }

    @Override
    public ResponseMap getProcurement(Integer id) {
        return responseMapUtil.getEntity(this.getById(id));
    }

    @Override
    public ResponseMap listProcurement(Integer page, Integer size) {
        Page<Procurement> pageList = pageUtil.getPageList(this.getBaseMapper(),pageUtil.getModelPage(page, size));
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }

    @Override
    public ResponseMap searchProcurement(SearchModel searchModel) {
        Page<Procurement> pageList = this.page(pageUtil.getModelPage(searchModel.getPage(), searchModel.getSize()),
                wrapperUtil.wrapperProcurement(searchModel.getSearch(), searchModel.getStartTime(), searchModel.getEndTime()));
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }
}




