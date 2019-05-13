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
        // FIXME: 12.05.2019
        if (orderService.makeOrder(shoppingCartService.getShoppingCart())) {
            //orderService.showAllOrders();
            System.out.println(shoppingCartService.buyAll());
        }
    }
}
