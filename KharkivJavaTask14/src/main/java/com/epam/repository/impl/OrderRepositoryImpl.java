package com.epam.repository.impl;

import com.epam.database.DataBaseManager;
import com.epam.repository.OrderRepository;

public class OrderRepositoryImpl implements OrderRepository {

    private DataBaseManager dataBaseManager;

    public OrderRepositoryImpl(DataBaseManager dataBaseManager) {
        this.dataBaseManager = dataBaseManager;
    }


}
