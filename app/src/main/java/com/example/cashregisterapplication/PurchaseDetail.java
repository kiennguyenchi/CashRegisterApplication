//Chi Kien Nguyen(158416180)
package com.example.cashregisterapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class PurchaseDetail  extends AppCompatActivity {
    TextView productName;
    TextView productPrice;
    TextView productDate;
    String product;
    String price;
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_purchase);

        product = getIntent().getExtras().getString("Product");
        price = getIntent().getExtras().getString("Total");
        date = getIntent().getExtras().getString("Date");

        productName = findViewById(R.id.detail_product);
        productPrice = findViewById(R.id.detail_price);
        productDate = findViewById(R.id.detail_date);

        productName.setText(product);
        productPrice.setText(price);
        productDate.setText(date);

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
}
