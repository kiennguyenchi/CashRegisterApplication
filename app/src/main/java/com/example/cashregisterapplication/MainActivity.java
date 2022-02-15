//Chi Kien Nguyen(158416180)
package com.example.cashregisterapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ListView productList;
    TextView productType;
    NumberPicker productQuantity;
    TextView totalQuantity;
    TextView totalAmount;
    int selectedProduct;
    Button buyButton;
    Button managerButton;
    ProductManager productManager;
    PurchaseManager purchaseManager;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get variables
        builder = new AlertDialog.Builder(this);
        productType = findViewById(R.id.productType);
        productQuantity = findViewById(R.id.quantityPicker);
        totalQuantity = findViewById(R.id.quantity);
        totalAmount = findViewById(R.id.totalAmount);
        buyButton = findViewById(R.id.buttonBuy);
        buyButton.setOnClickListener(this);
        managerButton = findViewById(R.id.managerButton);
        managerButton.setOnClickListener(this);
        productManager = ((MyApp)getApplication()).products;
        purchaseManager = ((MyApp)getApplication()).history;
        if(productManager.products.size() == 0){
            initializeProducts();
        }

        //event handler when list view item is clicked
        productList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedProduct = i;
                productType.setText(productManager.products.get(selectedProduct).name);
                productQuantity.setMinValue(0);
                productQuantity.setMaxValue(productManager.products.get(selectedProduct).quantity);
                productQuantity.setValue(0);
                totalAmount.setText(String.valueOf(0));
                totalQuantity.setText(String.valueOf(0));

            }
        });

        //event handler when quantity is chosen
        productQuantity.setOnScrollListener(new NumberPicker.OnScrollListener() {
            @Override
            public void onScrollStateChange(NumberPicker numberPicker, int scrollState) {
                if (scrollState == NumberPicker.OnScrollListener.SCROLL_STATE_IDLE) {
                    int quantity_value = numberPicker.getValue();
                    double total_value = quantity_value * productManager.products.get(selectedProduct).price;
                    totalQuantity.setText(String.valueOf(quantity_value));
                    totalAmount.setText(String.valueOf(total_value));
                }
            }
        });

    }

    //refresh the list view data
    @Override
    protected void onResume() {
        super.onResume();
        productList.setAdapter(new ProductBaseAdapter(productManager.products, this));
    }

    //initialize products when starting app
    void initializeProducts(){
        productList = findViewById(R.id.productsList);
        productManager.addProduct(new Product("Pante", 100, 20.44));
        productManager.addProduct(new Product("Shoes", 100, 10.44));
        productManager.addProduct(new Product("Hat", 100, 5.9));
        ProductBaseAdapter adapter = new ProductBaseAdapter(productManager.products, this);
        productList.setAdapter(adapter);
    }

    //handle click events
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id) {
            case R.id.managerButton:
                Intent managerIntent = new Intent(this, Manager.class);
                startActivity(managerIntent);
                break;
            case R.id.buttonBuy:
                if (productQuantity.getValue() == 0 || productType.getText() == "Product Type") {
                    Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_LONG).show();
                } else {
                    purchaseManager.addPurchase(new HistoryProduct(productManager.products.get(selectedProduct).name, productQuantity.getValue(), productManager.products.get(selectedProduct).price));

                    builder.setTitle("Thank You for your purchase!");
                    builder.setMessage("Your purchase is " + productQuantity.getValue()
                            + " " + productManager.products.get(selectedProduct).name + " for " + totalAmount.getText());
                    builder.setCancelable(true);
                    builder.setNegativeButton("OK",null);
                    builder.show();

                    productManager.products.get(selectedProduct).quantity -= productQuantity.getValue();
                    productType.setText("Product Type");
                    productQuantity.setValue(0);
                    productQuantity.setMaxValue(0);
                    totalQuantity.setText(String.valueOf(0));
                    totalAmount.setText(String.valueOf(0));
                    productList.setAdapter(new ProductBaseAdapter(productManager.products, this));
                }
                break;
        }
    }
}
