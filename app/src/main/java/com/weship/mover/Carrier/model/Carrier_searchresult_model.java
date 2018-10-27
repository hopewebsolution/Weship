package com.weship.mover.Carrier.model;

public class Carrier_searchresult_model {
    String id;
    String origin;
    String destination;
    String shipby;
    String candrive;
    String org_des;

    public Carrier_searchresult_model(String origin, String destination, String candrive, String shipby) {
        this.origin = origin;
        this.destination = destination;
        this.candrive= candrive;
        this.shipby = shipby;
    }
    public String getOrg_des() {
        return org_des;
    }

    public void setOrg_des(String org_des) {
        this.org_des = org_des;
    }

    public String getCandrive() {
        return candrive;
    }

    public void setCandrive(String candrive) {
        this.candrive = candrive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getShipby() {
        return shipby;
    }

    public void setShipby(String shipby) {
        this.shipby = shipby;
    }
}
