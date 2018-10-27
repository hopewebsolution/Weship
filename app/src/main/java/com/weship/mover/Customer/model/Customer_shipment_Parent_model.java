package com.weship.mover.Customer.model;

import com.weship.mover.Customer.fragment.Customer_shipment;

import java.util.ArrayList;

public class Customer_shipment_Parent_model {
    String title;
    ArrayList<Customer_shipment_model> bid=new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Customer_shipment_model> getBid() {
        return bid;
    }

    public void setBid(ArrayList<Customer_shipment_model> bid) {
        this.bid = bid;
    }
}
