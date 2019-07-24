package com.epam.model;

import com.epam.entity.Car;

import java.io.Serializable;

public class OrderItem implements Serializable {

    private static final long serialVersionUID = 8838431005867486476L;
    private Car car;
    private int days;

    public OrderItem() {
        super();
    }

    public OrderItem(Car car, int days) {
        this.car = car;
        this.days = days;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
