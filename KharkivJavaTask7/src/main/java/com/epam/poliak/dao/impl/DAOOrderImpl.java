package com.epam.poliak.dao.impl;

import com.epam.poliak.dao.DAOOrder;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.utils.Utils;

import java.util.*;

public class DAOOrderImpl implements DAOOrder {

    private NavigableMap<Date, Map<Transport, Integer>> orders = new TreeMap<>();

    @Override
    public void makeOrder(Map<Transport, Integer> hashMap, String date) {
        orders.put(Utils.getDate(date), new HashMap<>(hashMap));
    }

    @Override
    public NavigableMap<Date, Map<Transport, Integer>> getAllOrders() {
        return orders;
    }
}
