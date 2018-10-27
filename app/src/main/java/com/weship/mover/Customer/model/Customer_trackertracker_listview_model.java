package com.weship.mover.Customer.model;

public class Customer_trackertracker_listview_model {
    String id;
    String name;
    String location;
    String drivetime;
    String last_activity;
    String status;

    public Customer_trackertracker_listview_model(String name, String location, String drivetime, String last_activity, String status) {
        this.name = name;
        this.location = location;
        this.drivetime = drivetime;
        this.last_activity = last_activity;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDrivetime() {
        return drivetime;
    }

    public void setDrivetime(String drivetime) {
        this.drivetime = drivetime;
    }

    public String getLast_activity() {
        return last_activity;
    }

    public void setLast_activity(String last_activity) {
        this.last_activity = last_activity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
