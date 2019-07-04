package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.io.Reader;
import com.epam.poliak.io.Writer;
import com.epam.poliak.service.OrderService;
import com.epam.poliak.service.ShoppingCartService;
import com.epam.poliak.utils.Constants;
import com.epam.poliak.utils.ValidateUtils;

import java.util.InputMismatchException;

public class BuyAllCommand implements Command {

    private Reader reader;
    private Writer writer;
    private ShoppingCartService shoppingCartService;
    private OrderService orderService;

    public BuyAllCommand(Reader reader, Writer writer, ShoppingCartService shoppingCartService, OrderService orderService) {
        this.shoppingCartService = shoppingCartService;
        this.orderService = orderService;
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void doCommand() {
        writer.writeLine("Enter date(dd.MM.yyyy)");
        try {
            String date = reader.nextLine();
            if (ValidateUtils.validateEnter(date, Constants.DATE) && orderService.makeOrder(shoppingCartService.getShoppingCart(), date)) {
                writer.writeLine("Total: " + shoppingCartService.buyAll());
            }
        } catch (InputMismatchException ex) {
            writer.writeLine("Incorrect data");
            doCommand();
        }
    }
}
