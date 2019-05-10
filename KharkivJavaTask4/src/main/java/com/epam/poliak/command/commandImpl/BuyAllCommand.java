package com.epam.poliak.command.commandImpl;

import com.epam.poliak.command.Command;
import com.epam.poliak.service.impl.ShoppingCartImpl;

public class BuyAllCommand implements Command {

    @Override
    public void doCommand() {
        ShoppingCartImpl shoppingCart = new ShoppingCartImpl();
        shoppingCart.buyAll();
    }
}
