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

public class ProductBaseAdapter extends BaseAdapter {
    ArrayList<Product> products;
    Context context;

    public ProductBaseAdapter(ArrayList<Product> productList, Context context){
        this.products = productList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int i) {
        return products.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.item_rows, null);
        TextView productName = view.findViewById(R.id.productName);
        TextView productPrice = view.findViewById(R.id.productPrice);
        TextView productQuantity = view.findViewById(R.id.productQuantity);

        productName.setText(String.valueOf(products.get(i).name));
        productPrice.setText(String.valueOf(products.get(i).price));
        productQuantity.setText(String.valueOf(products.get(i).quantity));
        return view;
    }

}
