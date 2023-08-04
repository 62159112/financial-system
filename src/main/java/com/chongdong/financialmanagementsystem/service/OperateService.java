package com.chongdong.financialmanagementsystem.service;

import com.chongdong.financialmanagementsystem.model.Operate;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;

/**
* @author cd
* @description 针对表【tcd_operate(运营成本条目)】的数据库操作Service
* @createDate 2023-08-03 15:36:52
*/
public interface OperateService extends IService<Operate> {
    ResponseMap addOperate(Operate operate);

    ResponseMap updateOperate(Operate operate);

    ResponseMap deleteOperate(Integer id);

    ResponseMap getOperate(Integer id);

    ResponseMap listOperate(Integer page,Integer size);

    ResponseMap searchOperate(SearchModel searchModel);
}
