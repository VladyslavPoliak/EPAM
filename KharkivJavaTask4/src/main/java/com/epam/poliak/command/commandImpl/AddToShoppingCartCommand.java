package com.epam.poliak.command.commandImpl;

import com.epam.poliak.command.Command;
import com.epam.poliak.service.ShoppingCart;
import com.epam.poliak.service.impl.ShoppingCartImpl;

import java.util.Scanner;

public class AddToShoppingCartCommand implements Command {

    @Override
    public void doCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID машины");
        int idItem = scanner.nextInt();
        System.out.println("Введите оличество дней аренды");
        int days = scanner.nextInt();
        ShoppingCart shoppingCart = new ShoppingCartImpl();
        shoppingCart.addItemToShoppingCart(idItem, days);
    }
}
