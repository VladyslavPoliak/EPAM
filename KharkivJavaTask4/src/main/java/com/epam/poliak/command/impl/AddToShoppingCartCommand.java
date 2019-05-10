package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.service.ShoppingCartService;
import com.epam.poliak.service.impl.ShoppingCartServiceImpl;

import java.util.Scanner;

public class AddToShoppingCartCommand implements Command {

    private ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();

    @Override
    public void doCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID машины");
        int idItem = scanner.nextInt();
        System.out.println("Введите оличество дней аренды");
        int days = scanner.nextInt();
        shoppingCartService.addItemToShoppingCart(idItem, days);
    }
}
