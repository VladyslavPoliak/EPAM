package com.epam.poliak.service.impl;

import com.epam.poliak.dao.AllCarsDao;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.ShoppingCartService;
import com.epam.poliak.utils.Utils;

import java.util.Hashtable;
import java.util.Optional;

public class ShoppingCartServiceImpl implements ShoppingCartService {
    private AllCarsDao allCarsDao = new AllCarsDao();
    private Hashtable<Transport, Integer> shoppingCart;

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
        final long[] totalPrice = {0};
        shoppingCart = Utils.getCurrentShoppingCart();
        shoppingCart.forEach((k, v) -> totalPrice[0] += k.getPrice() * v);
        shoppingCart.clear();
        Utils.setCurrentShoppingCart(shoppingCart);
        return totalPrice[0];
    }

    @Override
    public void showCart() {
        shoppingCart = Utils.getCurrentShoppingCart();
        if (!shoppingCart.isEmpty()) {
            shoppingCart.forEach((k, v) -> System.out.println(k + " Rental days: " + v));
        } else {
            System.out.println("Корзина пустая");
        }
        Utils.setCurrentShoppingCart(shoppingCart);
    }
}
