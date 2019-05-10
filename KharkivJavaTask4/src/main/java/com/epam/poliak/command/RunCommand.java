package com.epam.poliak.command;

import com.epam.poliak.command.commandImpl.AddToShoppingCartCommand;
import com.epam.poliak.command.commandImpl.AllItemCommand;
import com.epam.poliak.command.commandImpl.BuyAllCommand;
import com.epam.poliak.command.commandImpl.ShowCartCommand;

import java.util.HashMap;
import java.util.Map;

public class RunCommand {

    private Map<Integer, Command> allCommandMap = new HashMap<>();

    public void executeCommand(int key) {
        if (key > fillCommandMap().size()) {
            System.out.println("Введена неправильная команда");
            return;
        }
        fillCommandMap().get(key).doCommand();
    }

    private Map<Integer, Command> fillCommandMap() {
        allCommandMap.put(1, new AllItemCommand());
        allCommandMap.put(2, new AddToShoppingCartCommand());
        allCommandMap.put(3, new ShowCartCommand());
        allCommandMap.put(4, new BuyAllCommand());
        return allCommandMap;
    }
}
