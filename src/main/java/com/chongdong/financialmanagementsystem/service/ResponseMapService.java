package com.chongdong.financialmanagementsystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chongdong.financialmanagementsystem.model.ResponseMap;

import java.util.List;
import java.util.Map;

public interface ResponseMapService<T> {
    ResponseMap getEntity(T entity);

    ResponseMap getPageList(Page<T> pageList, Map<String,Object> modelMap);

    ResponseMap updateEntity(boolean result);

    ResponseMap deleteEntity(boolean result);

    ResponseMap addEntity(boolean result);

    ResponseMap getList(List<T> entityList);
}
