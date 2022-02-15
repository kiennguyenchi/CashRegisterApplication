//Chi Kien Nguyen(158416180)
package com.example.cashregisterapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Restock extends AppCompatActivity implements View.OnClickListener{
    ProductManager productManager;
    ListView productsList;
    EditText newQuantity;
    Button okEdit;
    Button cancelEdit;
    int selectedProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restock);

        newQuantity = findViewById(R.id.edit_stock);
        okEdit = findViewById(R.id.btn_ok);
        okEdit.setOnClickListener(this);
        cancelEdit = findViewById(R.id.btn_cancel);
        cancelEdit.setOnClickListener(this);
        selectedProduct = -1;

        productsList = findViewById(R.id.restockList);
        productManager = ((MyApp)getApplication()).products;

        ProductBaseAdapter adapter = new ProductBaseAdapter(productManager.products, this);
        productsList.setAdapter(adapter);

        productsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedProduct = i;
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id) {
            case R.id.btn_ok:
                try {
                    int updateQuantity = Integer.valueOf(String.valueOf(newQuantity.getText()));
                    if(selectedProduct >=0 && selectedProduct < productManager.products.size()){
                        if(updateQuantity < 0){
                            Toast.makeText(this,"Quantity cannot be negative",Toast.LENGTH_LONG).show();
                        }else {
                            productManager.products.get(selectedProduct).quantity = updateQuantity;
                            productsList.setAdapter(new ProductBaseAdapter(productManager.products, this));
                        }
                    }else{
                        Toast.makeText(this,"An item must be chosen",Toast.LENGTH_LONG).show();
                    }
                }catch(Exception e){
                    Toast.makeText(this,"Invalid input",Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.btn_cancel:
                this.finish();
                break;
        }
    }
}
