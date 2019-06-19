package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.io.Writer;
import task9.server.Server;
import task9.wedCommand.WebCommandManager;

public class StartTCPServerCommand implements Command {

    private WebCommandManager commandManager;
    private Writer writer;

    public StartTCPServerCommand(Writer writer, WebCommandManager commandManager) {
        this.writer = writer;
        this.commandManager = commandManager;
    }

    @Override
    public void doCommand() {
        System.out.println("waiting for connection... ");
        new Thread(new Server(commandManager)).start();
    }
}
