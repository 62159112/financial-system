package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.model.Reimbursement;
import com.chongdong.financialmanagementsystem.service.ReimbursementService;
import com.chongdong.financialmanagementsystem.mapper.ReimbursementMapper;
import org.springframework.stereotype.Service;

/**
* @author cd
* @description 针对表【tcd_reimbursement(报销条目)】的数据库操作Service实现
* @createDate 2023-08-03 15:37:01
*/
@Service
public class IReimbursementService extends ServiceImpl<ReimbursementMapper, Reimbursement>
    implements ReimbursementService{

}




