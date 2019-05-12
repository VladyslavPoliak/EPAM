package com.epam.poliak.command;

import com.epam.poliak.command.impl.AddToShoppingCartCommand;
import com.epam.poliak.command.impl.AllItemCommand;
import com.epam.poliak.command.impl.BuyAllCommand;
import com.epam.poliak.command.impl.ShowCartCommand;

import java.util.HashMap;
import java.util.Map;

public class Controller {

    private Map<Integer, Command> allCommandMap = new HashMap<>();

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
        allCommandMap.put(1, new AllItemCommand());
        allCommandMap.put(2, new AddToShoppingCartCommand());
        allCommandMap.put(3, new ShowCartCommand());
        allCommandMap.put(4, new BuyAllCommand());
    }
}