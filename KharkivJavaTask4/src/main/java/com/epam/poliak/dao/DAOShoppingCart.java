package com.epam.poliak.dao;

import com.epam.poliak.entity.Transport;

import java.util.Map;

public interface DAOShoppingCart {

    void addItemToShoppingCart(Transport transport, int days);

    long buyAll();

    void showCart();

    void show5LastInCart();

    Map<Transport, Integer> getShoppingCart();

    int getDays(Transport transport);
}
