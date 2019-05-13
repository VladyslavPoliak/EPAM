package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.service.ShoppingCartService;

public class ShowLastCarsCommand implements Command {

    private ShoppingCartService shoppingCart;

    public ShowLastCarsCommand(ShoppingCartService shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void doCommand() {
        shoppingCart.show5LastInCart();
    }
}
