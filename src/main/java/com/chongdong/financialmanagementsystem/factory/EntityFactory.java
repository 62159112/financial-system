package com.chongdong.financialmanagementsystem.factory;

import com.chongdong.financialmanagementsystem.model.Income;
import com.chongdong.financialmanagementsystem.model.Payment;

public class EntityFactory {
    public static Payment createPayment(){return new Payment();}

    public static Income createIncome(){
        return new Income();
    }
}
