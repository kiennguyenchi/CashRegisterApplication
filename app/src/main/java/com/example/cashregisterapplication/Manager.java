//Chi Kien Nguyen(158416180)
package com.example.cashregisterapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Manager extends AppCompatActivity implements View.OnClickListener{
    Button buttonHistory;
    Button buttonRestock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager);

        buttonHistory = findViewById(R.id.btn_history);
        buttonHistory.setOnClickListener(this);

        buttonRestock = findViewById(R.id.btn_restock);
        buttonRestock.setOnClickListener(this);

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
            case R.id.btn_history:
                Intent historyIntent = new Intent(this, History.class);
                startActivity(historyIntent);
                break;
            case R.id.btn_restock:
                Intent restockIntent = new Intent(this, Restock.class);
                startActivity(restockIntent);
                break;
        }
    }
}
