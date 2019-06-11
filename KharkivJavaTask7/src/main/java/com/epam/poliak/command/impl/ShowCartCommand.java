package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.model.ShoppingCart;
import com.epam.poliak.service.ShoppingCartService;

import java.util.Map;

public class ShowCartCommand implements Command {

    private ShoppingCart shoppingCart;

    public ShowCartCommand(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void doCommand() {
        Map<Transport, Integer> map = shoppingCart.getShoppingCart();
        if (!map.isEmpty()) {
            map.forEach((k, v) -> System.out.println(k + " Rental days: " + v));
        } else {
            System.out.println("Empty basket");
        }
    }
}

