package com.epam.poliak.service.impl;

public class ServiceManager {
    private static ServiceManager serviceManager;
    private AllCarsServiceImpl allCarsService;
    private ShoppingCartServiceImpl shoppingCartService;

    private ServiceManager() {
        allCarsService = new AllCarsServiceImpl();
        shoppingCartService = new ShoppingCartServiceImpl();
    }

    public AllCarsServiceImpl getAllCarsService() {
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
}
