//Chi Kien Nguyen(158416180)
package com.example.cashregisterapplication;

import android.app.Application;

public class MyApp extends Application {
    ProductManager products = new ProductManager();
    PurchaseManager history = new PurchaseManager();
}
