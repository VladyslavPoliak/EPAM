package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.ShoppingCartService;

import java.util.Map;

public class ShowLastCarsCommand implements Command {

    private static final int LAST_5_ITEMS = 5;
    private ShoppingCartService shoppingCart;

    public ShowLastCarsCommand(ShoppingCartService shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void doCommand() {
        Map<Transport, Integer> map = shoppingCart.getShoppingCartStorage();
        if (!map.isEmpty()) {
            if (map.size() > LAST_5_ITEMS) {
                map.entrySet().stream().skip(map.size() - LAST_5_ITEMS).forEach(System.out::println);
            } else {
                map.forEach((k, v) -> System.out.println(k + " Rental days: " + v));
            }
        }
    }
}
