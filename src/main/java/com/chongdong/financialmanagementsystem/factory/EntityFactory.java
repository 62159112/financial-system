package com.chongdong.financialmanagementsystem.factory;

import com.chongdong.financialmanagementsystem.model.Expenses;
import com.chongdong.financialmanagementsystem.model.Income;
import com.chongdong.financialmanagementsystem.model.Inventory;
import com.chongdong.financialmanagementsystem.model.Payment;

public class EntityFactory {
    public static Payment createPayment(){return new Payment();}

    public static Income createIncome(){
        return new Income();
    }

    public static Inventory createInventory(){return new Inventory() ;}

    public static Expenses createExpenses(){return new Expenses();}
}
