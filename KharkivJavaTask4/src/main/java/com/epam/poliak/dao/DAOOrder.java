package com.epam.poliak.dao;

import com.epam.poliak.entity.Transport;

import java.util.Date;
import java.util.Map;

public interface DAOOrder {

    boolean makeOrder(Map<Transport, Integer> hashMap);

    Map<Date, Map<Transport, Integer>> findOrderByDate(Date date);

    Map<Date, Map<Transport, Integer>> findOrderByNearestDate(Date date);

    Map<Date, Map<Transport, Integer>> searchByTimeInterval(Date firstDate, Date secondDate);

}
