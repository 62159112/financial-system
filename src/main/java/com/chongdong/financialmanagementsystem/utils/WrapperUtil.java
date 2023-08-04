package com.chongdong.financialmanagementsystem.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Service
public class WrapperUtil<T> {

    public QueryWrapper<T> wrapperNormal(String search, String startTime, String endTime) {
        LocalDateTime start = LocalDateTime.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime end = LocalDateTime.parse(endTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.hasLength(search), "name", search);
        wrapper.like(StringUtils.hasLength(search), "type", search);
        wrapper.like(StringUtils.hasLength(search), "amount", search);
        wrapper.like(StringUtils.hasLength(search), "director", search);
        wrapper.between(StringUtils.hasLength(startTime) && StringUtils.hasLength(endTime), "create_time", start, end);
        return wrapper;
    }

    public QueryWrapper<T> wrapperGetOne(String name, Date createTime){
        LocalDateTime localDateTime = createTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.eq("name",name);
        wrapper.eq("create_time",localDateTime);
        return wrapper;
    }
}
