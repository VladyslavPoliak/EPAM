package com.epam.poliak.service;

import com.epam.poliak.entity.Transport;

import java.util.Date;
import java.util.Map;
import java.util.NavigableMap;

public interface OrderService {

    void makeOrder(Map<Transport, Integer> hashMap, String date);

    NavigableMap<Date, Map<Transport, Integer>> findOrderByDate(Date date);

    NavigableMap<Date, Map<Transport, Integer>> findOrderByNearestDate(Date date);

    NavigableMap<Date, Map<Transport, Integer>> searchByTimeInterval(Date firstDate, Date secondDate);

}
