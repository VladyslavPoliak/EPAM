package com.epam.poliak.service;

import com.epam.poliak.entity.Transport;

import java.util.Map;

public interface ShoppingCartService {

    void addItemToShoppingCart(Transport transport, int days);

    long buyAll();

    Map<Transport, Integer> getShoppingCart();

    Map<Transport, Integer> getShoppingCartStorage();

}
