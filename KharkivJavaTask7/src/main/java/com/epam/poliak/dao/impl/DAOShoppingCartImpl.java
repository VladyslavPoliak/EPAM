package com.epam.poliak.dao.impl;

import com.epam.poliak.dao.DAOShoppingCart;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.utils.Constants;

import java.util.*;

public class DAOShoppingCartImpl implements DAOShoppingCart {

    private Map<Transport, Integer> shoppingCart;
    private Map<Transport, Integer> shoppingCartStorage;

    public DAOShoppingCartImpl() {
        shoppingCart = new HashMap<>();
        shoppingCartStorage = new LinkedHashMap<Transport, Integer>(5, 1f, true) {
            protected boolean removeEldestEntry(Map.Entry<Transport, Integer> eldest) {
                return size() > Constants.MAX_ITEMS_IN_LINKED_MAP;
            }
        };
    }

    @Override
    public void addItemToShoppingCart(Transport transport, int days) {
        if (Objects.nonNull(transport)) {
            shoppingCart.put(transport, days);
            shoppingCartStorage.put(transport, days);

        } else {
            throw new InputMismatchException("This transport is missing. Try later");
        }
    }

    @Override
    public void clearShoppingCart() {
        shoppingCart.clear();
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

    @Override
    public Map<Transport, Integer> getShoppingCartStorage() {
        return shoppingCartStorage;
    }
}

