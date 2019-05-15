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
        return daoShoppingCart.buyAll();
    }

    @Override
    public void showCart() {
        daoShoppingCart.showCart();
    }

    @Override
    public void show5LastInCart() {
        daoShoppingCart.show5LastInCart();
    }

    @Override
    public Map<Transport, Integer> getShoppingCart() {
        return daoShoppingCart.getShoppingCart();
    }
}
