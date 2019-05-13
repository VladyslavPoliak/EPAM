package com.epam.poliak.dao;

import com.epam.poliak.entity.Transport;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShoppingCartDao {

    private Map<Transport, Integer> shoppingCart = new HashMap<>();
    private Map<Transport, Integer> linkedHashMap = new LinkedHashMap<>();

    public Map<Transport, Integer> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(HashMap<Transport, Integer> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Map<Transport, Integer> getLinkedHashMap() {
        return linkedHashMap;
    }

    public void setLinkedHashMap(Map<Transport, Integer> linkedHashMap) {
        this.linkedHashMap = linkedHashMap;
    }
}

