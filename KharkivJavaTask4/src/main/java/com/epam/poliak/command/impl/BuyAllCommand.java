package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.service.OrderService;
import com.epam.poliak.service.ShoppingCartService;

public class BuyAllCommand implements Command {

    private ShoppingCartService shoppingCartService;
    private OrderService orderService;

    public BuyAllCommand(ShoppingCartService shoppingCartService, OrderService orderService) {
        this.shoppingCartService = shoppingCartService;
        this.orderService = orderService;
    }

    @Override
    public void doCommand() {
        if (orderService.makeOrder(shoppingCartService.getShoppingCart())) {
            System.out.println("Total: " + shoppingCartService.buyAll());
        }
    }
}
