package com.epam.poliak.service.impl;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.OrderService;

import java.util.Hashtable;

public class OrderServiceImpl implements OrderService {

    private Hashtable<Transport, Integer> shoppingCart = ServiceManager.getInstance().getShoppingCartService().getShoppingCart();

    @Override
    public void makeOrder() {

    }
}
