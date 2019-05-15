package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.service.ShoppingCartService;
import com.epam.poliak.service.TransportService;
import com.epam.poliak.utils.Utils;

import java.util.Scanner;

public class AddToShoppingCartCommand implements Command {

    private TransportService transportService;
    private ShoppingCartService shoppingCartService;

    public AddToShoppingCartCommand(ShoppingCartService shoppingCartService, TransportService transportService) {
        this.shoppingCartService = shoppingCartService;
        this.transportService = transportService;
    }

    @Override
    public void doCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID машины");
        int idItem = scanner.nextInt();
        System.out.println("Введите количество дней аренды");
        int days = scanner.nextInt();
        shoppingCartService.addItemToShoppingCart(transportService.getTransportByID(idItem), Utils.validateNumber(days));
    }
}
