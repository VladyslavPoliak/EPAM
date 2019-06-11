package com.epam.poliak.service.impl;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.model.Order;
import com.epam.poliak.service.OrderService;
import com.epam.poliak.utils.DateUtils;

import java.util.Date;
import java.util.Map;
import java.util.NavigableMap;

public class OrderServiceImpl implements OrderService {

    private Order order;
    private NavigableMap<Date, Map<Transport, Integer>> allOrders;

    public OrderServiceImpl(Order order) {
        this.order = order;
        allOrders = order.getAllOrders();
    }

    @Override
    public void makeOrder(Map<Transport, Integer> hashMap, String date) {
        if (!hashMap.isEmpty()) {
            order.addOrder(hashMap, date);
        } else {
            System.out.println("Empty basket");
        }
    }

    @Override
    public NavigableMap<Date, Map<Transport, Integer>> findOrderByDate(Date date) {
        return allOrders.subMap(date, true, date, true);
    }

    @Override
    public NavigableMap<Date, Map<Transport, Integer>> findOrderByNearestDate(Date date) {
        Date nearestDate = DateUtils.determineNearestDate(date, allOrders.floorKey(date), allOrders.ceilingKey(date));
        return allOrders.subMap(nearestDate, true, nearestDate, true);
    }

    @Override
    public NavigableMap<Date, Map<Transport, Integer>> searchByTimeInterval(Date firstDate, Date secondDate) {
        return allOrders.subMap(firstDate, true, secondDate, true);
    }
}
