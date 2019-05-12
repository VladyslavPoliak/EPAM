package com.epam.poliak.service.impl;

import com.epam.poliak.service.AllCarsService;
import com.epam.poliak.service.OrderService;

public class ServiceManager {
    private static ServiceManager serviceManager;
    private AllCarsService allCarsService;
    private ShoppingCartServiceImpl shoppingCartService;
    private OrderService orderService;

    private ServiceManager() {
        allCarsService = new AllCarsServiceImpl();
        shoppingCartService = new ShoppingCartServiceImpl();
        orderService = new OrderServiceImpl();
    }

    public AllCarsService getAllCarsService() {
        return allCarsService;
    }

    public ShoppingCartServiceImpl getShoppingCartService() {
        return shoppingCartService;
    }

    public static ServiceManager getInstance() {
        if (serviceManager == null) {
            serviceManager = new ServiceManager();
            return serviceManager;
        }
        return serviceManager;
    }

    public OrderService getOrderService() {
        return orderService;
    }
}
