package com.epam.poliak.service;

import com.epam.poliak.entity.Transport;

import java.util.Map;

public interface OrderService {

    void makeOrder(Map<Transport, Integer> hashMap);

    void showAllOrders();
}
