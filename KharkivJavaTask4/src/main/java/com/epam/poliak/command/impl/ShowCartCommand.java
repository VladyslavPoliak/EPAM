package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.service.impl.ShoppingCartServiceImpl;

public class ShowCartCommand implements Command {

    private ShoppingCartServiceImpl shoppingCart = new ShoppingCartServiceImpl();

    @Override
    public void doCommand() {
        shoppingCart.showCart();
    }
}

