package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.model.ShoppingCartStorage;
import com.epam.poliak.service.ShoppingCartService;
import com.epam.poliak.service.TransportService;
import com.epam.poliak.utils.ValidateUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddToShoppingCartCommand implements Command {

    private TransportService transportService;
    private ShoppingCartService shoppingCartService;
    private ShoppingCartStorage shoppingCartStorage;

    public AddToShoppingCartCommand(ShoppingCartService shoppingCartService, TransportService transportService, ShoppingCartStorage shoppingCartStorage) {
        this.shoppingCartService = shoppingCartService;
        this.transportService = transportService;
        this.shoppingCartStorage = shoppingCartStorage;
    }

    @Override
    public void doCommand() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter ID transport");
            int idItem = scanner.nextInt();
            System.out.println("Enter number of rental days");
            int days = scanner.nextInt();
            shoppingCartService.addItemToShoppingCart(transportService.getTransportByID(idItem), ValidateUtils.validateDays(days));
            shoppingCartStorage.addToCartStorage(transportService.getTransportByID(idItem), ValidateUtils.validateDays(days));
        } catch (InputMismatchException ex) {
            System.out.println("Incorrect data");
            doCommand();
        }
    }
}
