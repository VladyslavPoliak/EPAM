package com.epam.poliak.dao;

import com.epam.poliak.entity.Transport;

import java.util.Map;

public interface DAOShoppingCart {

    void addItemToShoppingCart(Transport transport, int days);

    long buyAll();

    Map<Transport, Integer> getShoppingCart();

    Map<Transport, Integer> getShoppingCartStorage();

    int getDays(Transport transport);
}
