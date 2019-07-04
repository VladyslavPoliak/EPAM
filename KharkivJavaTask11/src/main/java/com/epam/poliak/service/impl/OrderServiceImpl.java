package com.epam.poliak.service.impl;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.io.Writer;
import com.epam.poliak.model.Order;
import com.epam.poliak.service.OrderService;
import com.epam.poliak.utils.DateUtils;

import java.util.Date;
import java.util.Map;
import java.util.NavigableMap;

public class OrderServiceImpl implements OrderService {

    private Writer writer;
    private Order order;
    private NavigableMap<Date, Map<Transport, Integer>> allOrders;

    public OrderServiceImpl(Writer writer, Order order) {
        this.order = order;
        this.writer = writer;
        allOrders = order.getAllOrders();
    }

    @Override
    public boolean makeOrder(Map<Transport, Integer> hashMap, String date) {
        if (!hashMap.isEmpty()) {
            order.addOrder(hashMap, date);
            return true;
        } else {
            writer.writeLine("Empty basket");
            return false;
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
