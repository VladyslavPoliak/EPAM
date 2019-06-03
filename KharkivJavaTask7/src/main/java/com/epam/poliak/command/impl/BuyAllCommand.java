package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.service.OrderService;
import com.epam.poliak.service.ShoppingCartService;
import com.epam.poliak.utils.Constants;
import com.epam.poliak.utils.Utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BuyAllCommand implements Command {

    private ShoppingCartService shoppingCartService;
    private OrderService orderService;

    public BuyAllCommand(ShoppingCartService shoppingCartService, OrderService orderService) {
        this.shoppingCartService = shoppingCartService;
        this.orderService = orderService;
    }

    @Override
    public void doCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date(dd.MM.yyyy)");
        try {
            String date = scanner.nextLine();
            if (Utils.validateEnter(date, Constants.DATE)) {
                orderService.makeOrder(shoppingCartService.getShoppingCart(), date);
                System.out.println("Total: " + shoppingCartService.buyAll());
            }
        } catch (InputMismatchException ex) {
            System.out.println("Incorrect data");
            doCommand();
        }
    }
}
