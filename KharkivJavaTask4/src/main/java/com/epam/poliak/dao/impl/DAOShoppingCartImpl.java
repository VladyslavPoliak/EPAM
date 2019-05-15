package com.epam.poliak.dao.impl;

import com.epam.poliak.dao.DAOShoppingCart;
import com.epam.poliak.entity.Transport;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class DAOShoppingCartImpl implements DAOShoppingCart {

    private static final int LAST_5_ITEMS = 5;
    private Map<Transport, Integer> shoppingCart;
    private Map<Transport, Integer> shoppingCartStorage;

    public DAOShoppingCartImpl() {
        shoppingCart = new HashMap<>();
        shoppingCartStorage = new LinkedHashMap<>();
    }

    @Override
    public void addItemToShoppingCart(Transport transport, int days) {
        if (Objects.nonNull(transport)) {
            shoppingCart.put(transport, days);
            shoppingCartStorage.put(transport, days);
        } else {
            System.out.println("Этот автомобиль отсутствует");
        }
    }

    @Override
    public long buyAll() {
        final long[] totalPrice = {0};
        shoppingCart.forEach((k, v) -> totalPrice[0] += k.getPrice() * v);
        shoppingCart.clear();
        return totalPrice[0];
    }

    @Override
    public void showCart() {
        if (!shoppingCart.isEmpty()) {
            shoppingCart.forEach((k, v) -> System.out.println(k + " Rental days: " + v));
        } else {
            System.out.println("Корзина пустая");
        }
    }

    @Override
    public void show5LastInCart() {
        if (!shoppingCartStorage.isEmpty()) {
            if (shoppingCartStorage.size() > LAST_5_ITEMS) {
                shoppingCartStorage.entrySet().stream().skip(shoppingCartStorage.size() - LAST_5_ITEMS).forEach(System.out::println);
            } else {
                shoppingCartStorage.forEach((k, v) -> System.out.println(k + " Rental days: " + v));
            }
        }
    }

    @Override
    public Map<Transport, Integer> getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public int getDays(Transport transport) {
        if (shoppingCart.containsKey(transport)) {
            return shoppingCart.get(transport);
        }
        return 0;
    }
}

