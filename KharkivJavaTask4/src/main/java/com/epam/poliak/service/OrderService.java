package com.epam.poliak.service;

import com.epam.poliak.entity.Transport;

import java.util.Date;
import java.util.Map;

public interface OrderService {

    boolean makeOrder(Map<Transport, Integer> hashMap);

    void showAllOrders();

    void findOrderByDate(Date date);

    void findOrderByNearestDate(Date date);

}
