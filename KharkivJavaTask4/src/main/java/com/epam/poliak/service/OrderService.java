package com.epam.poliak.service;

import com.epam.poliak.entity.Transport;

import java.util.Hashtable;

public interface OrderService {

    void makeOrder(Hashtable<Transport, Integer> hashtable);

    void showAllOrders();
}
