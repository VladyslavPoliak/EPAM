package com.epam.poliak.model;

import com.epam.poliak.entity.Transport;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Objects;

public class ShoppingCart {

    private Map<Transport, Integer> shoppingCart;
    private ShoppingCartStorage storage;

    public ShoppingCart(ShoppingCartStorage storage) {
        shoppingCart = new HashMap<>();
        this.storage = storage;
    }

    public void addItemToShoppingCart(Transport transport, int days) {
        if (Objects.nonNull(transport)) {
            shoppingCart.put(transport, days);
            storage.addToCartStorage(transport, days);
        } else {
            throw new InputMismatchException("This transport is missing. Try later");
        }
    }

    public void clearShoppingCart() {
        shoppingCart.clear();
    }

    public Map<Transport, Integer> getShoppingCart() {
        return shoppingCart;
    }

    public int getDays(Transport transport) {
        if (shoppingCart.containsKey(transport)) {
            return shoppingCart.get(transport);
        }
        return 0;
    }
}
