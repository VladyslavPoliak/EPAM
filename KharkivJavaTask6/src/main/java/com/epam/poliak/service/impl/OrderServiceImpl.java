package com.epam.poliak.service.impl;

import com.epam.poliak.dao.DAOOrder;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.OrderService;

import java.util.Date;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private DAOOrder daoOrder;

    public OrderServiceImpl(DAOOrder daoOrder) {
        this.daoOrder = daoOrder;
    }

    @Override
    public boolean makeOrder(Map<Transport, Integer> hashMap) {
        return daoOrder.makeOrder(hashMap);
    }

    @Override
    public Map<Date, Map<Transport, Integer>> findOrderByDate(Date date) {
        return daoOrder.findOrderByDate(date);
    }

    @Override
    public Map<Date, Map<Transport, Integer>> findOrderByNearestDate(Date date) {
        return daoOrder.findOrderByNearestDate(date);
    }

    @Override
    public Map<Date, Map<Transport, Integer>> searchByTimeInterval(Date firstDate, Date secondDate) {
        return daoOrder.searchByTimeInterval(firstDate, secondDate);
    }
}
