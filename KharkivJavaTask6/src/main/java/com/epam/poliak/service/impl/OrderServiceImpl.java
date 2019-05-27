package com.epam.poliak.service.impl;

import com.epam.poliak.dao.DAOOrder;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.OrderService;
import com.epam.poliak.utils.Utils;

import java.util.Date;
import java.util.Map;
import java.util.NavigableMap;

public class OrderServiceImpl implements OrderService {

    private DAOOrder daoOrder;
    private NavigableMap<Date, Map<Transport, Integer>> orders;

    public OrderServiceImpl(DAOOrder daoOrder) {
        this.daoOrder = daoOrder;
        orders = daoOrder.getAllOrders();
    }

    @Override
    public void makeOrder(Map<Transport, Integer> hashMap, String date) {
        if (!hashMap.isEmpty()) {
            daoOrder.makeOrder(hashMap, date);
        } else {
            System.out.println("Empty basket");
        }
    }

    @Override
    public NavigableMap<Date, Map<Transport, Integer>> findOrderByDate(Date date) {
        return orders.subMap(date, true, date, true);
    }

    @Override
    public NavigableMap<Date, Map<Transport, Integer>> findOrderByNearestDate(Date date) {
        Date nearestDate = Utils.determineNearestDate(date, orders.floorKey(date), orders.ceilingKey(date));
        return orders.subMap(nearestDate, true, nearestDate, true);
    }

    @Override
    public NavigableMap<Date, Map<Transport, Integer>> searchByTimeInterval(Date firstDate, Date secondDate) {
        return orders.subMap(firstDate, true, secondDate, true);
    }
}
