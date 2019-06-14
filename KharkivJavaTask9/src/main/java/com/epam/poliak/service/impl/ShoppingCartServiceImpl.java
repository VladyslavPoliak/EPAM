package com.epam.poliak.service.impl;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.model.ShoppingCart;
import com.epam.poliak.service.ShoppingCartService;

import java.util.Map;

public class ShoppingCartServiceImpl implements ShoppingCartService {

    private ShoppingCart shoppingCart;

    public ShoppingCartServiceImpl(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void addItemToShoppingCart(Transport transport, int days) {
        int newDays = get(transport);
        shoppingCart.addItemToShoppingCart(transport, days + newDays);
    }

    @Override
    public long buyAll() {
        Map<Transport, Integer> shoppingCart = this.shoppingCart.getShoppingCart();
        long totalPrice = shoppingCart.entrySet().stream().mapToLong(k -> k.getKey().getPrice() * k.getValue()).sum();
        this.shoppingCart.clearShoppingCart();
        return totalPrice;
    }

    @Override
    public int get(Transport transport) {
        return shoppingCart.getDays(transport);
    }

    @Override
    public Map<Transport, Integer> getShoppingCart() {
        return shoppingCart.getShoppingCart();
    }
}
