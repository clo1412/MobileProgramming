package com.example.ezyfood;

import java.io.Serializable;

public class MyOrderClass implements Serializable {
    private String menuName;
    private int price, qty;

    public MyOrderClass(String menuName, int price, int qty){
        this.menuName = menuName;
        this.price = price;
        this.qty = qty;
    }

    public String getMenuName(){
        return menuName;
    }

    public void setMenuName(String menuName){
        this.menuName = menuName;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getQty(){
        return qty;
    }

    public void setQty(int qty){
        this.qty = qty;
    }
}
