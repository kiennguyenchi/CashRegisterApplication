//Chi Kien Nguyen(158416180)
package com.example.cashregisterapplication;

import java.util.ArrayList;

public class PurchaseManager {
    ArrayList<HistoryProduct> historyList = new ArrayList(0);
    public void addPurchase(HistoryProduct p){
        historyList.add(p);
    }
}
