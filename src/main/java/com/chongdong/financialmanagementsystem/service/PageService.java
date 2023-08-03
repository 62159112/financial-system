package com.chongdong.financialmanagementsystem.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Map;

public interface PageService<T>{
    Map<String,Object> getModelMap(Page<T> iPage);

    Page<T> getModelPage(Integer page,Integer size);

    Page<T> getPageList(BaseMapper<T> baseMapper,Page<T> page);
}
