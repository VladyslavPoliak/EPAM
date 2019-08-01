package com.epam.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class Order implements Serializable {

    private static final long serialVersionUID = 2272568621136182687L;
    private int id;
    private int idAccount;
    private List<OrderItem> items;
    private String status;

    private String statusDescription;

    private Timestamp created;

    public Order() {
    }

    public Order(int id, int idAccount, String status, String statusDescription, Timestamp created) {
        this.id = id;
        this.idAccount = idAccount;
        this.status = status;
        this.statusDescription = statusDescription;
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

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
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
            for (OrderItem item : items) {
                cost = cost.add(BigDecimal.valueOf(item.getCar().getCost()).multiply(BigDecimal.valueOf(item.getDays())));
            }
        }
        return cost;
    }
}
