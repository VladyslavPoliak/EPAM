package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.service.ShoppingCartService;

public class ShowCartCommand implements Command {

    private ShoppingCartService shoppingCart;

    public ShowCartCommand(ShoppingCartService shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void doCommand() {
        shoppingCart.showCart();
    }
}

