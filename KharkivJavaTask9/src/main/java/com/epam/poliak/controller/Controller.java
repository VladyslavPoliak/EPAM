package com.epam.poliak.controller;

import com.epam.poliak.command.Command;
import com.epam.poliak.command.impl.*;
import com.epam.poliak.input.InputHelper;
import com.epam.poliak.input.InputLocale;
import com.epam.poliak.input.InputStrategy;
import com.epam.poliak.io.Reader;
import com.epam.poliak.io.Writer;
import com.epam.poliak.model.Order;
import com.epam.poliak.model.ShoppingCart;
import com.epam.poliak.model.ShoppingCartStorage;
import com.epam.poliak.repository.RepositoryImpl;
import com.epam.poliak.service.OrderService;
import com.epam.poliak.service.ShoppingCartService;
import com.epam.poliak.service.ShoppingCartStorageService;
import com.epam.poliak.service.TransportService;
import com.epam.poliak.service.impl.OrderServiceImpl;
import com.epam.poliak.service.impl.ShoppingCartServiceImpl;
import com.epam.poliak.service.impl.ShoppingCartStorageImpl;
import com.epam.poliak.service.impl.TransportServiceImpl;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class Controller {

    private Reader reader;
    private Writer writer;
    private ShoppingCart shoppingCart;
    private ShoppingCartStorage shoppingCartStorage;
    private Map<Integer, Command> allCommandMap;
    private ShoppingCartService shoppingCartService;
    private ShoppingCartStorageService shoppingCartStorageService;
    private TransportService transportService;
    private OrderService orderService;
    private InputHelper helper;
    private Locale locale;


    public Controller(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
        allCommandMap = new HashMap<>();
        shoppingCartStorage = new ShoppingCartStorage();
        shoppingCart = new ShoppingCart();
        shoppingCartService = new ShoppingCartServiceImpl(shoppingCart);
        shoppingCartStorageService = new ShoppingCartStorageImpl(shoppingCartStorage, shoppingCartService);
        transportService = new TransportServiceImpl(new RepositoryImpl());
        orderService = new OrderServiceImpl(writer, new Order());
        helper = new InputStrategy(reader, writer).setInputStrategy();
        locale = new InputLocale(reader, writer).setLocale();
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
        allCommandMap.put(1, new AllItemCommand(writer, transportService));
        allCommandMap.put(2, new AddToShoppingCartCommand(reader, writer, shoppingCartService, transportService, shoppingCartStorageService));
        allCommandMap.put(3, new ShowCartCommand(writer, shoppingCartService));
        allCommandMap.put(4, new BuyAllCommand(reader, writer, shoppingCartService, orderService));
        allCommandMap.put(5, new ShowLastCarsCommand(writer, shoppingCartStorage));
        allCommandMap.put(6, new SearchOrderByDateCommand(reader, writer, orderService));
        allCommandMap.put(7, new SearchByTimeIntervalCommand(reader, writer, orderService));
        allCommandMap.put(8, new SearchForNearestDateCommand(reader, writer, orderService));
        allCommandMap.put(9, new AddNewTransport(reader, writer, transportService, helper));
        allCommandMap.put(10, new AddNewTransportReflection(reader, writer, transportService, helper, ResourceBundle.getBundle("content", locale)));
    }
}