package com.chongdong.financialmanagementsystem.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chongdong.financialmanagementsystem.model.Labor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class PageUtil<T> {
    /**
     * ��ȡ���ݣ��������ݼ���ҳ��Ϣ
     * */
    public Map<String, Object> getModelMap(Page<T> iPage) {
        Map<String,Object> map = new HashMap<>();
        if (iPage.getRecords().size()>0){
            map.put("record",iPage.getRecords());
            map.put("pageCount",iPage.getPages());
            map.put("total",iPage.getTotal());
            map.put("pageNow",iPage.getCurrent());
            map.put("pageSize",iPage.getSize());
            return map;
        }else {
            return null;
        }
    }
    /**
     * ����Ĭ�Ϸ�ҳ����
     * */
    public Page<T> getModelPage(Integer page, Integer size) {
        if (page==null){
            page = 1;
        }
        if (size == null){
            size = 5;
        }
        return new Page<>(page,size);
    }
    /**
     * ��ȡʵ�����ҳ�б�
     * */
    public Page<T> getPageList(BaseMapper<T> baseMapper, Page<T> page) {
        return new LambdaQueryChainWrapper<>(baseMapper).page(page);
    }

}
