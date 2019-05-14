package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.service.ShoppingCartService;
import com.epam.poliak.utils.Utils;

import java.util.Scanner;

public class AddToShoppingCartCommand implements Command {


    private ShoppingCartService shoppingCartService;

    public AddToShoppingCartCommand(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public void doCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID машины");
        int idItem = scanner.nextInt();
        System.out.println("Введите количество дней аренды");
        int days = scanner.nextInt();
        shoppingCartService.addItemToShoppingCart(idItem, Utils.validateNumber(days));
    }
}
