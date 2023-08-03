package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.model.Type;
import com.chongdong.financialmanagementsystem.service.TypeService;
import com.chongdong.financialmanagementsystem.mapper.TypeMapper;
import org.springframework.stereotype.Service;

/**
* @author cd
* @description 针对表【tcd_type(类型管理)】的数据库操作Service实现
* @createDate 2023-08-03 15:37:08
*/
@Service
public class ITypeService extends ServiceImpl<TypeMapper, Type>
    implements TypeService{

}




