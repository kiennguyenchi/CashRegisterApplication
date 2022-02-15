//Chi Kien Nguyen(158416180)
package com.example.cashregisterapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryBaseAdapter extends BaseAdapter {
    ArrayList<HistoryProduct> purchases;
    Context context;

    public HistoryBaseAdapter(ArrayList<HistoryProduct> purchases, Context context){
        this.purchases = purchases;
        this.context = context;
    }

    @Override
    public int getCount() {
        return purchases.size();
    }

    @Override
    public Object getItem(int i) {
        return purchases.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.item_rows, null);
        TextView productPurchase = view.findViewById(R.id.productName);
        TextView quantityPurchase = view.findViewById(R.id.productPrice);
        TextView totalPurchase = view.findViewById(R.id.productQuantity);

        productPurchase.setText(String.valueOf(purchases.get(i).product));
        quantityPurchase.setText(String.valueOf(purchases.get(i).quantity));
        totalPurchase.setText(String.valueOf(purchases.get(i).total));
        return view;
    }

}
