package com.epam.poliak.model;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.utils.DateUtils;

import java.util.*;

public class Order {

    private NavigableMap<Date, Map<Transport, Integer>> orders = new TreeMap<>();

    public void makeOrder(Map<Transport, Integer> hashMap, String date) {
        orders.put(DateUtils.getDate(date), new HashMap<>(hashMap));
    }

    public NavigableMap<Date, Map<Transport, Integer>> getAllOrders() {
        return orders;
    }
}
