package com.epam.poliak.service.impl;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.ShoppingCart;
import com.epam.poliak.utils.Utils;

import java.util.Hashtable;
import java.util.Map;
import java.util.Optional;

public class ShoppingCartImpl implements ShoppingCart {

    private Hashtable<Transport, Integer> shoppingCart;

    @Override
    public void addItemToShoppingCart(int itemId, int days) {
        shoppingCart = Utils.getShoppingCart();
        Optional<Transport> transportOptional = Utils.getAllItemList().stream()
                .filter(c -> c.getId() == itemId)
                .findAny();
        if (transportOptional.isPresent()) {
            Transport idCar = transportOptional.get();
            shoppingCart.put(idCar, days);
            Utils.updateAllItemList(itemId);
        } else {
            System.out.println("Этот автомобиль отсутствует");
        }
        Utils.setShoppingCart(shoppingCart);
    }

    @Override
    public long buyAll() {
        long totalPrice = 0;
        shoppingCart = Utils.getShoppingCart();
        for (Map.Entry<Transport, Integer> entry : shoppingCart.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
        shoppingCart.clear();
        Utils.setShoppingCart(shoppingCart);
        return totalPrice;
    }

    @Override
    public void showCart() {
        shoppingCart = Utils.getShoppingCart();
        if (shoppingCart.size() > 0) {
            for (Map.Entry<Transport, Integer> entry : shoppingCart.entrySet()) {
                System.out.println(entry.getKey() + " Rental days: " + entry.getValue());
            }
        } else {
            System.out.println("Корзина пустая");
        }
        Utils.setShoppingCart(shoppingCart);
    }
}
