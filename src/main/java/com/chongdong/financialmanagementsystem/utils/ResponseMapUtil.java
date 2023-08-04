package com.chongdong.financialmanagementsystem.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chongdong.financialmanagementsystem.factory.MapFactory;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ResponseMapUtil<T>{
    ResponseMap responseMap = MapFactory.createResponseMap();
    /**
     * ��ȡ����ʵ���෵������
     * */
    public ResponseMap getEntity(T entity) {
        if (entity!=null){
            responseMap.setFlag(true);
            responseMap.setData(entity);
            responseMap.setMessage("��ѯ�����ɹ�");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(null);
            responseMap.setMessage("��ѯ����ʧ��");
        }
        return responseMap;
    }
    /**
     * ��ȡʵ�����ҳ�б�������
     * */
    public ResponseMap getPageList(Page<T> pageList, Map<String, Object> modelMap) {
        if (pageList.getRecords().size()!=0){
            responseMap.setFlag(true);
            responseMap.setData(modelMap);
            responseMap.setMessage("��ѯ�б�ɹ�");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(null);
            responseMap.setMessage("��ѯ�б�ʧ��");
        }
        return responseMap;
    }
    /**
     * ����ʵ���෵�ؽ��
     * */
    public ResponseMap updateEntity(boolean result) {
        if (result){
            responseMap.setFlag(true);
            responseMap.setData(null);
            responseMap.setMessage("�޸ĳɹ�");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(null);
            responseMap.setMessage("�޸�ʧ��");
        }
        return responseMap;
    }
    /**
     * ɾ��ʵ���෵�ؽ��
     * */
    public ResponseMap deleteEntity(boolean result) {
        if (result){
            responseMap.setFlag(true);
            responseMap.setData(null);
            responseMap.setMessage("ɾ���ɹ�");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(null);
            responseMap.setMessage("ɾ��ʧ��");
        }
        return responseMap;
    }
    /**
     * ���ʵ���෵�ؽ��
     * */
    public ResponseMap addEntity(boolean result) {
        if (result){
            responseMap.setFlag(true);
            responseMap.setData(null);
            responseMap.setMessage("�����ɹ�");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(null);
            responseMap.setMessage("����ʧ��");
        }
        return responseMap;
    }
    /**
     * ��ȡʵ�����б��ؽ��
     * */
    public ResponseMap getList(List<T> entityList) {
        if (entityList.size()!=0){
            responseMap.setFlag(true);
            responseMap.setData(entityList);
            responseMap.setMessage("��ѯ�б�ɹ�");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(null);
            responseMap.setMessage("��ѯ�б�ʧ��");
        }
        return responseMap;
    }
}
