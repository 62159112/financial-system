package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.model.Operate;
import com.chongdong.financialmanagementsystem.service.OperateService;
import com.chongdong.financialmanagementsystem.mapper.OperateMapper;
import org.springframework.stereotype.Service;

/**
* @author cd
* @description 针对表【tcd_operate(运营成本条目)】的数据库操作Service实现
* @createDate 2023-08-03 15:36:52
*/
@Service
public class IOperateService extends ServiceImpl<OperateMapper, Operate>
    implements OperateService{

}




