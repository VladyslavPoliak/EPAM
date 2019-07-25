package com.epam.entity;

import java.io.Serializable;

public class OrderItem implements Serializable {

    private static final long serialVersionUID = 3305300532571071231L;
    private int id;
    private int idOrder;
    private Car car;
    private int days;

    public OrderItem(Car car, int days) {
        this.car = car;
        this.days = days;
    }

    public OrderItem() {
    }

    public int getId() {
        return id;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public Car getCar() {
        return car;
    }

    public int getDays() {
        return days;
    }

}
