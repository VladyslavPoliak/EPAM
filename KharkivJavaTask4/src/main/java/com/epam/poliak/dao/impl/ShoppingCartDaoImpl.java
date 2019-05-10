package com.epam.poliak.dao.impl;

import com.epam.poliak.dao.ShoppingCartDao;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.utils.Utils;

import java.util.*;

public class ShoppingCartDaoImpl implements ShoppingCartDao {

    private Hashtable<Transport, Integer> shoppingCart;
    private AllCarsDaoImpl allCarsDao = new AllCarsDaoImpl();

    @Override
    public void addItemToShoppingCart(int itemId, int days) {
        shoppingCart = Utils.getCurrentShoppingCart();
        Optional<Transport> transportOptional = allCarsDao.getAllItemList().stream()
                .filter(c -> c.getId() == itemId)
                .findAny();
        if (transportOptional.isPresent()) {
            Transport transport = transportOptional.get();
            shoppingCart.put(transport, days);
            allCarsDao.updateAllItemList(itemId);
        } else {
            System.out.println("Этот автомобиль отсутствует");
        }
        Utils.setCurrentShoppingCart(shoppingCart);
    }

    @Override
    public long buyAll() {
        long totalPrice = 0;
        shoppingCart = Utils.getCurrentShoppingCart();
        for (Map.Entry<Transport, Integer> entry : shoppingCart.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
        shoppingCart.clear();
        Utils.setCurrentShoppingCart(shoppingCart);
        return totalPrice;
    }

    @Override
    public void showCart() {
        shoppingCart = Utils.getCurrentShoppingCart();
        if (!shoppingCart.isEmpty()) {
            for (Map.Entry<Transport, Integer> entry : shoppingCart.entrySet()) {
                System.out.println(entry.getKey() + " Rental days: " + entry.getValue());
            }
        } else {
            System.out.println("Корзина пустая");
        }
        Utils.setCurrentShoppingCart(shoppingCart);
    }

    @Override
    public void showLastCars() {
        shoppingCart = Utils.getCurrentShoppingCart();
        Map<Transport, Date> map = new LinkedHashMap<>();
        if (!shoppingCart.isEmpty()) {
            for (Map.Entry<Transport, Integer> entry : shoppingCart.entrySet()) {
                System.out.println(entry.getKey() + " Rental days: " + entry.getValue());
            }
        } else {
            System.out.println("Корзина пустая");
        }
    }

}

