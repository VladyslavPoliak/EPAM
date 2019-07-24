package com.epam.entity;

public class OrderItemEntity {

    private int id;
    private int idOrder;
    private Car car;
    private int days;

    public OrderItemEntity(int id, int days, Car car) {
        this.id = id;
        this.days = days;
        this.car = car;
    }

    public OrderItemEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
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
