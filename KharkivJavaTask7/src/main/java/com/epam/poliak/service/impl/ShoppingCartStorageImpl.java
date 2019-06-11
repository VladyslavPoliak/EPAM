package com.epam.poliak.service.impl;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.model.ShoppingCartStorage;
import com.epam.poliak.service.ShoppingCartService;
import com.epam.poliak.service.ShoppingCartStorageService;

import java.util.Map;

public class ShoppingCartStorageImpl implements ShoppingCartStorageService {

    private ShoppingCartStorage storage;
    private ShoppingCartService shoppingCartService;

    public ShoppingCartStorageImpl(ShoppingCartStorage storage,ShoppingCartService shoppingCartService) {
        this.storage = storage;
        this.shoppingCartService=shoppingCartService;
    }

    @Override
    public Map<Transport, Integer> getShoppingCartStorage() {
        return storage.getShoppingCartStorage();
    }

    @Override
    public void addItemToShoppingCartStorage(Transport transport, int days) {
        int newDays = shoppingCartService.get(transport);
        storage.addToCartStorage(transport, days + newDays);
    }
}
