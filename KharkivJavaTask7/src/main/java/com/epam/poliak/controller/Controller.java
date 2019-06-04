package com.epam.poliak.controller;

import com.epam.poliak.command.Command;
import com.epam.poliak.command.impl.*;
import com.epam.poliak.dao.impl.DAOOrderImpl;
import com.epam.poliak.dao.impl.DAOShoppingCartImpl;
import com.epam.poliak.dao.impl.DAOTransportImpl;
import com.epam.poliak.input.InputHelper;
import com.epam.poliak.input.InputLocale;
import com.epam.poliak.input.InputStrategy;
import com.epam.poliak.service.OrderService;
import com.epam.poliak.service.ShoppingCartService;
import com.epam.poliak.service.TransportService;
import com.epam.poliak.service.impl.OrderServiceImpl;
import com.epam.poliak.service.impl.ShoppingCartServiceImpl;
import com.epam.poliak.service.impl.TransportServiceImpl;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class Controller {

    private Map<Integer, Command> allCommandMap;
    private ShoppingCartService shoppingCartService;
    private TransportService transportService;
    private OrderService orderService;
    private InputHelper helper;
    private Locale locale;

    public Controller() {
        allCommandMap = new HashMap<>();
        shoppingCartService = new ShoppingCartServiceImpl(new DAOShoppingCartImpl());
        transportService = new TransportServiceImpl(new DAOTransportImpl());
        orderService = new OrderServiceImpl(new DAOOrderImpl());
        helper = new InputStrategy().setInputStrategy();
        locale=new InputLocale().setLocale();
        fillCommandMap();
    }

    public void executeCommand(int key) {
        allCommandMap.get(key).doCommand();
    }

    public Map<Integer, Command> getAllCommandMap() {
        return allCommandMap;
    }

    private void fillCommandMap() {
        allCommandMap.put(0, new ExitCommand(transportService, "serialisation.txt"));
        allCommandMap.put(1, new AllItemCommand(transportService));
        allCommandMap.put(2, new AddToShoppingCartCommand(shoppingCartService, transportService));
        allCommandMap.put(3, new ShowCartCommand(shoppingCartService));
        allCommandMap.put(4, new BuyAllCommand(shoppingCartService, orderService));
        allCommandMap.put(5, new ShowLastCarsCommand(shoppingCartService));
        allCommandMap.put(6, new SearchOrderByDateCommand(orderService));
        allCommandMap.put(7, new SearchByTimeIntervalCommand(orderService));
        allCommandMap.put(8, new SearchForNearestDateCommand(orderService));
        allCommandMap.put(9, new AddNewTransport(transportService, helper));
        allCommandMap.put(10,new AddNewTransportReflection(transportService,helper,ResourceBundle.getBundle("content",locale)));
    }
}
