package com.chongdong.financialmanagementsystem.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chongdong.financialmanagementsystem.factory.MapFactory;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class ResponseMapUtil<T>{
    ResponseMap responseMap = MapFactory.createResponseMap();
    /**
     * 获取单个实体类返回数据
     * */
    public ResponseMap getEntity(T entity) {
        if (entity!=null){
            responseMap.setFlag(true);
            responseMap.setData(entity);
            responseMap.setMessage("查询单个成功");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(null);
            responseMap.setMessage("查询单个失败");
        }
        return responseMap;
    }
    /**
     * 获取实体类分页列表返回数据
     * */
    public ResponseMap getPageList(Page<T> pageList, Map<String, Object> modelMap) {
        if (pageList.getRecords().size()!=0){
            responseMap.setFlag(true);
            responseMap.setData(modelMap);
            responseMap.setMessage("查询列表成功");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(null);
            responseMap.setMessage("查询列表失败");
        }
        return responseMap;
    }
    /**
     * 更新实体类返回结果
     * */
    public ResponseMap updateEntity(boolean result) {
        if (result){
            responseMap.setFlag(true);
            responseMap.setData(null);
            responseMap.setMessage("修改成功");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(null);
            responseMap.setMessage("修改失败");
        }
        return responseMap;
    }
    /**
     * 删除实体类返回结果
     * */
    public ResponseMap deleteEntity(boolean result) {
        if (result){
            responseMap.setFlag(true);
            responseMap.setData(null);
            responseMap.setMessage("删除成功");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(null);
            responseMap.setMessage("删除失败");
        }
        return responseMap;
    }
    /**
     * 添加实体类返回结果
     * */
    public ResponseMap addEntity(boolean result) {
        if (result){
            responseMap.setFlag(true);
            responseMap.setData(null);
            responseMap.setMessage("新增成功");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(null);
            responseMap.setMessage("新增失败");
        }
        return responseMap;
    }
    /**
     * 获取实体类列表返回结果
     * */
    public ResponseMap getList(List<T> entityList) {
        if (entityList.size()!=0){
            responseMap.setFlag(true);
            responseMap.setData(entityList);
            responseMap.setMessage("查询列表成功");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(null);
            responseMap.setMessage("查询列表失败");
        }
        return responseMap;
    }

    public ResponseMap countList(BigDecimal countAmount){
        if (countAmount!=null){
            responseMap.setFlag(true);
            responseMap.setData(countAmount);
            responseMap.setMessage("统计列表成功");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(null);
            responseMap.setMessage("统计列表失败");
        }
        return responseMap;
    }
}
