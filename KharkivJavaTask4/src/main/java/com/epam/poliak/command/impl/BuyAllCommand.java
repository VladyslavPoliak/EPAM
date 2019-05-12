package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.service.ShoppingCartService;
import com.epam.poliak.service.impl.ServiceManager;

public class BuyAllCommand implements Command {

    private ShoppingCartService shoppingCart = ServiceManager.getInstance().getShoppingCartService();

    @Override
    public void doCommand() {
        System.out.println(shoppingCart.buyAll());
    }
}
