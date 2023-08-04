package com.chongdong.financialmanagementsystem.factory;

import com.chongdong.financialmanagementsystem.model.Income;
import com.chongdong.financialmanagementsystem.model.Pay;

public class EntityFactory {
    public static Pay createPay(){return new Pay();}

    public static Income createIncome(){
        return new Income();
    }
}
