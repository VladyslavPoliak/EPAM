package com.epam.poliak.dao;

import com.epam.poliak.entity.Transport;

import java.util.Date;
import java.util.Map;

public interface DAOOrder {

    boolean makeOrder(Map<Transport, Integer> hashMap);

    void findOrderByDate(Date date);

    void findOrderByNearestDate(Date date);

}
