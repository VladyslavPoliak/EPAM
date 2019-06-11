package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.model.ShoppingCartStorage;

import java.util.Map;

public class ShowLastCarsCommand implements Command {

    private ShoppingCartStorage storage;

    public ShowLastCarsCommand(ShoppingCartStorage shoppingCartStorage) {
        this.storage = shoppingCartStorage;
    }

    @Override
    public void doCommand() {
        Map<Transport, Integer> map = storage.getShoppingCartStorage();
        if (!map.isEmpty()) {
            map.forEach((k, v) -> System.out.println(k + " Rental days: " + v));
        }
    }
}
