//Chi Kien Nguyen(158416180)
package com.example.cashregisterapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class History extends AppCompatActivity{
    PurchaseManager purchaseManager;
    ListView historyList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        purchaseManager = ((MyApp)getApplication()).history;
        historyList = findViewById(R.id.historyList);
        HistoryBaseAdapter adapter = new HistoryBaseAdapter(purchaseManager.historyList, this);
        historyList.setAdapter(adapter);

        historyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent detailIntent = new Intent(History.this, PurchaseDetail.class);
                detailIntent.putExtra("Product", "Product: " + purchaseManager.historyList.get(i).product);
                detailIntent.putExtra("Total", "Price: " + String.valueOf(purchaseManager.historyList.get(i).total));
                detailIntent.putExtra("Date", "Purchase Date: " + purchaseManager.historyList.get(i).date);
                startActivity(detailIntent);
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
}
