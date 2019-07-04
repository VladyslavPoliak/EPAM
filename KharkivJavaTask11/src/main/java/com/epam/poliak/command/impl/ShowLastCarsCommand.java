package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.io.Writer;
import com.epam.poliak.model.ShoppingCartStorage;

import java.util.Map;

public class ShowLastCarsCommand implements Command {

    private ShoppingCartStorage storage;
    private Writer writer;

    public ShowLastCarsCommand(Writer writer, ShoppingCartStorage shoppingCartStorage) {
        this.storage = shoppingCartStorage;
        this.writer = writer;
    }

    @Override
    public void doCommand() {
        Map<Transport, Integer> map = storage.getShoppingCartStorage();
        if (!map.isEmpty()) {
            map.forEach((k, v) -> writer.writeLine(k + " Rental days: " + v));
        }
    }
}
