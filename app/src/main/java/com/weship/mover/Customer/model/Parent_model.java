package com.weship.mover.Customer.model;

import java.util.ArrayList;

public class Parent_model {
    String title;
    ArrayList<Customer_bids> bid=new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Customer_bids> getBid() {
        return bid;
    }

    public void setBid(ArrayList<Customer_bids> bid) {
        this.bid = bid;
    }
}
