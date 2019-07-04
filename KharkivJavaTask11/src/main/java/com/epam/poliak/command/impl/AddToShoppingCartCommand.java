package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.io.Reader;
import com.epam.poliak.io.Writer;
import com.epam.poliak.service.ShoppingCartService;
import com.epam.poliak.service.ShoppingCartStorageService;
import com.epam.poliak.service.TransportService;
import com.epam.poliak.utils.ValidateUtils;

import java.util.InputMismatchException;

public class AddToShoppingCartCommand implements Command {

    private TransportService transportService;
    private ShoppingCartService shoppingCartService;
    private ShoppingCartStorageService shoppingCartStorageService;
    private Reader reader;
    private Writer writer;

    public AddToShoppingCartCommand(Reader reader, Writer writer, ShoppingCartService shoppingCartService, TransportService transportService, ShoppingCartStorageService shoppingCartStorageService) {
        this.shoppingCartService = shoppingCartService;
        this.transportService = transportService;
        this.shoppingCartStorageService = shoppingCartStorageService;
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void doCommand() {
        try {
            writer.writeLine("Enter ID transport");
            int idItem = reader.nextInt();
            writer.writeLine("Enter number of rental days");
            int days = reader.nextInt();
            shoppingCartService.addItemToShoppingCart(transportService.getTransportByID(idItem), ValidateUtils.validateDays(days));
            shoppingCartStorageService.addItemToShoppingCartStorage(transportService.getTransportByID(idItem), ValidateUtils.validateDays(days));
        } catch (InputMismatchException ex) {
            writer.writeLine("Incorrect data");
            doCommand();
        }
    }
}
