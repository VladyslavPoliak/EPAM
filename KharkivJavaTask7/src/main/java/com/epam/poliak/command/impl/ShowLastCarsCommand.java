package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.ShoppingCartService;

import java.util.Map;

public class ShowLastCarsCommand implements Command {

    private ShoppingCartService shoppingCartService;

    public ShowLastCarsCommand(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public void doCommand() {
        Map<Transport, Integer> map = shoppingCartService.getShoppingCartStorage();
        if (!map.isEmpty()) {
            map.forEach((k, v) -> System.out.println(k + " Rental days: " + v));
        }
    }
}
