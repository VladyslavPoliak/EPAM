package com.epam.poliak.service.impl;

import com.epam.poliak.dao.DAOShoppingCart;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.ShoppingCartService;

import java.util.Map;

public class ShoppingCartServiceImpl implements ShoppingCartService {

    private DAOShoppingCart daoShoppingCart;

    public ShoppingCartServiceImpl(DAOShoppingCart daoShoppingCart) {
        this.daoShoppingCart = daoShoppingCart;
    }

    @Override
    public void addItemToShoppingCart(Transport transport, int days) {
        int newDays = daoShoppingCart.getDays(transport);
        daoShoppingCart.addItemToShoppingCart(transport, days + newDays);
    }

    @Override
    public long buyAll() {
        Map<Transport, Integer> shoppingCart = daoShoppingCart.getShoppingCart();
        final long[] totalPrice = {0};
        shoppingCart.forEach((k, v) -> totalPrice[0] += k.getPrice() * v);
        daoShoppingCart.clearShoppingCart();
        return totalPrice[0];
    }

    @Override
    public Map<Transport, Integer> getShoppingCart() {
        return daoShoppingCart.getShoppingCart();
    }

    @Override
    public Map<Transport, Integer> getShoppingCartStorage() {
        return daoShoppingCart.getShoppingCartStorage();
    }
}
