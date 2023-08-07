package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.factory.EntityFactory;
import com.chongdong.financialmanagementsystem.model.*;
import com.chongdong.financialmanagementsystem.service.ExpensesService;
import com.chongdong.financialmanagementsystem.mapper.ExpensesMapper;
import com.chongdong.financialmanagementsystem.service.PaymentService;
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
* @description 针对表【tcd_expenses(费用支出条目)】的数据库操作Service实现
* @createDate 2023-08-03 17:04:45
*/
@Service
public class IExpensesService extends ServiceImpl<ExpensesMapper, Expenses>
    implements ExpensesService{
    @Resource
    PageUtil<Expenses> pageUtil;
    @Resource
    WrapperUtil<Expenses> wrapperUtil;
    @Resource
    ResponseMapUtil<Expenses> responseMapUtil;
    @Resource
    PaymentService paymentService;

    Payment payment = EntityFactory.createPayment();

    @Override
    @Transactional
    public ResponseMap addExpenses(Expenses expenses) {
        expenses.setCreateTime(new Date());
        BeanUtils.copyProperties(expenses,payment);
        payment.setType("费用成本");
        return responseMapUtil.addEntity(this.save(expenses) && paymentService.addOtherWithPayment(payment));
    }

    @Override
    @Transactional
    public ResponseMap updateExpenses(Expenses expenses) {
        BeanUtils.copyProperties(expenses,payment);
        payment.setId(null);
        payment.setType(null);
        return responseMapUtil.updateEntity(this.updateById(expenses) && paymentService.updateOtherWithPayment(payment));
    }

    @Override
    @Transactional
    public ResponseMap deleteExpenses(Integer id) {
        Expenses expenses = this.getById(id);
        BeanUtils.copyProperties(expenses,payment);
        payment.setId(null);
        payment.setType(null);
        return responseMapUtil.deleteEntity(this.removeById(id) && paymentService.deleteOtherWithPayment(payment));
    }

    @Override
    public ResponseMap getExpenses(Integer id) {
        return responseMapUtil.getEntity(this.getById(id));
    }

    @Override
    public ResponseMap listExpenses(Integer page, Integer size) {
        Page<Expenses> pageList = pageUtil.getPageList(this.getBaseMapper(),pageUtil.getModelPage(page, size));
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }

    @Override
    public ResponseMap searchExpenses(SearchModel searchModel) {
        Page<Expenses> pageList = this.page(pageUtil.getModelPage(searchModel.getPage(), searchModel.getSize()),
                wrapperUtil.wrapperExpenses(searchModel.getSearch(), searchModel.getStartTime(), searchModel.getEndTime()));
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }
    @Override
    public Boolean updateWithPayment(Expenses expenses){
        Expenses oldExpenses = this.getOne(wrapperUtil.wrapperTime(expenses.getCreateTime()));
        expenses.setId(oldExpenses.getId());
        return this.updateById(expenses);
    }

    @Override
    public Boolean deleteWithPayment(Expenses expenses) {
        Expenses oldExpenses = this.getOne(wrapperUtil.wrapperTime(expenses.getCreateTime()));
        return this.removeById(oldExpenses.getId());
    }
}




