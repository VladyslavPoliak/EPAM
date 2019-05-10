package com.epam.poliak.service.impl;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.ShoppingCart;

import java.util.Hashtable;
import java.util.Map;
import java.util.Optional;

public class ShoppingCartImpl implements ShoppingCart {

    private Hashtable<Transport, Integer> shoppingCart = new Hashtable<>();

    @Override
    public void addItemToShoppingCart(int itemId, int days) {
        AllCarsImpl allCars = new AllCarsImpl();
        Optional<Transport> transportOptional = allCars.getAllItemList().stream()
                .filter(c -> c.getId() == itemId)
                .findAny();
        if (transportOptional.isPresent()) {
            Transport result = transportOptional.get();
            shoppingCart.put(result, days);
        } else {
            System.out.println("Этот автомобиль отсутствует");
        }
    }

    @Override
    public void buyAll() {
        long totalPrice = 0;
        for (Map.Entry<Transport, Integer> entry : shoppingCart.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
        shoppingCart.clear();
        System.out.println(totalPrice);
    }

    @Override
    public void showCart() {
        if (shoppingCart.size() > 0) {
            for (Map.Entry<Transport, Integer> entry : shoppingCart.entrySet()) {
                System.out.println(entry.getKey() + " Rental days: " + entry.getValue());
            }
        } else {
            System.out.println("Корзина пустая");
        }
    }

    public Hashtable<Transport, Integer> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Hashtable<Transport, Integer> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
