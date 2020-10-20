package com.example.satw.Item;

import com.example.satw.Controller;

public class Item {
    String item_name;
    int item_money;
    private Controller controller;
    public Item(){
        this.controller= Controller.getInstance();
    }
    public void setItem_info(String item_name,int item_money){
        this.item_name=item_name;
        this.item_money=item_money;
    }
    public int get_item_money(){
        return item_money;
    }
    public String get_item_name(){
        return item_name;
    }
}
