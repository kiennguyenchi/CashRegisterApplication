//Chi Kien Nguyen(158416180)
package com.example.cashregisterapplication;

public class Product {
    String name;
    int quantity;
    double price;

    public Product(){
        this.name = "";
        this.quantity = 0;
        this.price = 0;
    }

    public Product(String name, int quantity, double price){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
