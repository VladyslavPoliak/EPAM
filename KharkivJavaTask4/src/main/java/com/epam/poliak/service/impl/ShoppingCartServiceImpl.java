package com.epam.poliak.service.impl;

import com.epam.poliak.dao.AllTransportDao;
import com.epam.poliak.dao.ShoppingCartDao;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.ShoppingCartService;

import java.util.Map;
import java.util.Optional;

public class ShoppingCartServiceImpl implements ShoppingCartService {

    private static final int LAST_5_ITEMS = 5;
    private AllTransportDao allTransportDao = new AllTransportDao();
    private ShoppingCartDao shoppingCartDao = new ShoppingCartDao();
    private Map<Transport, Integer> shoppingCart = shoppingCartDao.getShoppingCart();
    private Map<Transport, Integer> map = shoppingCartDao.getLinkedHashMap();

    @Override
    public void addItemToShoppingCart(int itemId, int days) {
        Optional<Transport> transportOptional = allTransportDao.getAllItemList().stream()
                .filter(c -> c.getId() == itemId)
                .findAny();
        if (transportOptional.isPresent()) {
            Transport transport = transportOptional.get();
            shoppingCart.put(transport, days);
            map.put(transport, days);
        } else {
            System.out.println("Этот автомобиль отсутствует");
        }
    }

    @Override
    public long buyAll() {
        final long[] totalPrice = {0};
        shoppingCart.forEach((k, v) -> totalPrice[0] += k.getPrice() * v);
        shoppingCart.clear();
        return totalPrice[0];
    }

    @Override
    public void showCart() {
        if (!shoppingCart.isEmpty()) {
            shoppingCart.forEach((k, v) -> System.out.println(k + " Rental days: " + v));
        } else {
            System.out.println("Корзина пустая");
        }
    }

    @Override
    public void show5LastInCart() {
        if (!map.isEmpty()) {
            if (map.size() > LAST_5_ITEMS) {
                map.entrySet().stream().skip(map.size() - LAST_5_ITEMS).forEach(System.out::println);
            } else {
                map.forEach((k, v) -> System.out.println(k + " Rental days: " + v));
            }
        }
    }

    public Map<Transport, Integer> getShoppingCart() {
        return shoppingCart;
    }
}
