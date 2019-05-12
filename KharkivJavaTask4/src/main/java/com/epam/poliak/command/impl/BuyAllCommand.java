package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.service.OrderService;
import com.epam.poliak.service.impl.ServiceManager;
import com.epam.poliak.service.impl.ShoppingCartServiceImpl;

public class BuyAllCommand implements Command {

    private ShoppingCartServiceImpl shoppingCartService = ServiceManager.getInstance().getShoppingCartService();
    private OrderService orderService = ServiceManager.getInstance().getOrderService();

    @Override
    public void doCommand() {
        // FIXME: 12.05.2019 
        orderService.makeOrder(shoppingCartService.getShoppingCart());
        orderService.showAllOrders();
        System.out.println(shoppingCartService.buyAll());

        // TODO: 12.05.2019  


    }
}
