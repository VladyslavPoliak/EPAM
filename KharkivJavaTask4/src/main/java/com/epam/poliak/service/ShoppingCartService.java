package com.epam.poliak.service;

import com.epam.poliak.entity.Transport;

import java.util.Map;

public interface ShoppingCartService {

    void addItemToShoppingCart(int itemId, int days);

    long buyAll();

    void showCart();

    void show5LastInCart();

    Map<Transport, Integer> getShoppingCart();
}
