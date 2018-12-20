package com.example.hiennv.loigiaihay.db.model;

import java.io.Serializable;

public class OrderId implements Serializable {
    private int orderId;
    private String orderIdName;

    public OrderId(int orderId, String orderIdName) {
        this.orderId = orderId;
        this.orderIdName = orderIdName;
    }

    public OrderId(String orderIdName) {
        this.orderIdName = orderIdName;
    }

    public OrderId() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderIdName() {
        return orderIdName;
    }

    public void setOrderIdName(String orderIdName) {
        this.orderIdName = orderIdName;
    }
}
