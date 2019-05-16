package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.service.ShoppingCartService;
import com.epam.poliak.service.TransportService;
import com.epam.poliak.utils.Constants;
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
        String idItem = scanner.nextLine();
        System.out.println("Введите количество дней аренды");
        String days = scanner.nextLine();
        if (Utils.validateEnter(idItem, Constants.NUMBERS) && Utils.validateEnter(days, Constants.NUMBERS)) {
            shoppingCartService.addItemToShoppingCart(transportService.getTransportByID(Integer.parseInt(idItem))
                    , Utils.validateNumber(Integer.parseInt(days)));
        }
        System.out.println("Введены неправильные данные");
    }
}
