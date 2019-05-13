package com.epam.poliak.controller;

import com.epam.poliak.command.Command;
import com.epam.poliak.command.impl.*;
import com.epam.poliak.service.AllCarsService;
import com.epam.poliak.service.OrderService;
import com.epam.poliak.service.ShoppingCartService;
import com.epam.poliak.service.impl.AllCarsServiceImpl;
import com.epam.poliak.service.impl.OrderServiceImpl;
import com.epam.poliak.service.impl.ShoppingCartServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class Controller {

    private Map<Integer, Command> allCommandMap = new HashMap<>();
    private ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();
    private AllCarsService allCarsService = new AllCarsServiceImpl();
    private OrderService orderService = new OrderServiceImpl();

    public Controller() {
        fillCommandMap();
    }

    public void executeCommand(int key) {
        allCommandMap.get(key).doCommand();
    }

    public Map<Integer, Command> getAllCommandMap() {
        return allCommandMap;
    }

    private void fillCommandMap() {
        allCommandMap.put(1, new AllItemCommand(allCarsService));
        allCommandMap.put(2, new AddToShoppingCartCommand(shoppingCartService));
        allCommandMap.put(3, new ShowCartCommand(shoppingCartService));
        allCommandMap.put(4, new BuyAllCommand(shoppingCartService, orderService));
        allCommandMap.put(5, new ShowLastCarsCommand(shoppingCartService));
        allCommandMap.put(6, new ViewOrderCommand(orderService));
    }
}
