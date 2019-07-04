package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.io.Writer;
import com.epam.poliak.service.ShoppingCartService;

import java.util.Map;

public class ShowCartCommand implements Command {

    private ShoppingCartService shoppingCartService;
    private Writer writer;

    public ShowCartCommand(Writer writer, ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
        this.writer = writer;
    }

    @Override
    public void doCommand() {
        Map<Transport, Integer> map = shoppingCartService.getShoppingCart();
        if (!map.isEmpty()) {
            map.forEach((k, v) -> writer.writeLine(k + " Rental days: " + v));
        } else {
            writer.writeLine("Empty basket");
        }
    }
}

