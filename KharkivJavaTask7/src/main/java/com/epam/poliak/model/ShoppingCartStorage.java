package com.epam.poliak.model;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.utils.Constants;

import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class ShoppingCartStorage {

    private Map<Transport, Integer> shoppingCartStorage;

    public ShoppingCartStorage() {
        this.shoppingCartStorage = new LinkedHashMap<Transport, Integer>(5, 1f, true) {
            protected boolean removeEldestEntry(Map.Entry<Transport, Integer> eldest) {
                return size() > Constants.MAX_ITEMS_IN_LINKED_MAP;
            }
        };
    }

    public void addToCartStorage(Transport transport, int days) {
        if (Objects.nonNull(transport)) {
            shoppingCartStorage.put(transport, days);
        } else {
            throw new InputMismatchException("This transport is missing. Try later");
        }
    }

    public Map<Transport, Integer> getShoppingCartStorage() {
        return shoppingCartStorage;
    }
}
