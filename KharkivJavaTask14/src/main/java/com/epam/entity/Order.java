package com.epam.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class Order {

    private int id;
    private int idAccount;
    private List<OrderItemEntity> items;
    private Timestamp created;

    public Order() {
    }

    public Order(Integer id, Integer idAccount, Timestamp created) {
        this.id = id;
        this.idAccount = idAccount;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public List<OrderItemEntity> getItems() {
        return items;
    }

    public void setItems(List<OrderItemEntity> items) {
        this.items = items;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public BigDecimal getTotalCost() {
        BigDecimal cost = BigDecimal.ZERO;
        if (items != null) {
            for (OrderItemEntity item : items) {
                cost = cost.add(BigDecimal.valueOf(item.getCar().getCost()).multiply(BigDecimal.valueOf(item.getDays())));
            }
        }
        return cost;
    }
}
