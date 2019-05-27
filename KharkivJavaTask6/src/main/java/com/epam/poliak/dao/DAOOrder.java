package com.epam.poliak.dao;

import com.epam.poliak.entity.Transport;

import java.util.Date;
import java.util.Map;
import java.util.NavigableMap;

public interface DAOOrder {

    void makeOrder(Map<Transport, Integer> hashMap, String date);

    NavigableMap<Date, Map<Transport, Integer>> getAllOrders();

}
