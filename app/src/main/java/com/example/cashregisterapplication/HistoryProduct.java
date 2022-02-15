//Chi Kien Nguyen(158416180)
package com.example.cashregisterapplication;

import java.util.Date;

public class HistoryProduct {
    String product;
    int quantity;
    double total;
    Date date;

    public HistoryProduct(){
        this.product = "";
        this.quantity = 0;
        this.total = 0;
        this.date = new Date();
    }

    public HistoryProduct(String name, int quantity, double price){
        this.product = name;
        this.quantity = quantity;
        this.total = quantity*price;
        this.date = new Date();
    }
}
