package com.example.prabaths.VO;

import java.util.Date;

/**
 * Created by prabath s on 5/2/2016.
 */
public class InstantData {
    private Date date;
    private double unitPrice;
    private String userID;
    private int carID;

    public InstantData(int carID, Date date, double unitPrice, String userID) {
        this.carID = carID;
        this.date = date;
        this.unitPrice = unitPrice;
        this.userID = userID;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
