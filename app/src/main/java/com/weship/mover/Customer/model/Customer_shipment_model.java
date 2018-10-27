package com.weship.mover.Customer.model;

public class Customer_shipment_model {
    String id;
    String model;
    String origin;
    String destination;
    String del_window;

    public String getDel_window() {
        return del_window;
    }

    public void setDel_window(String del_window) {
        this.del_window = del_window;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

}
