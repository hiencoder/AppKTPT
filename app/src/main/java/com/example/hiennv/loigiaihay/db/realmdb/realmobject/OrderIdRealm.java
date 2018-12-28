package com.example.hiennv.loigiaihay.db.realmdb.realmobject;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class OrderIdRealm extends RealmObject {
    @PrimaryKey
    private int orderId;
    private String orderIdName;

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
