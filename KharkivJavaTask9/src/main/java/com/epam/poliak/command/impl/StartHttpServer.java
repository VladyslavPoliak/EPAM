package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.io.Writer;
import task9.WebCommandManager;
import task9.server.http.HttpServer;

public class StartHttpServer implements Command {

    private WebCommandManager commandManager;
    private Writer writer;

    public StartHttpServer(Writer writer, WebCommandManager commandManager) {
        this.writer = writer;
        this.commandManager = commandManager;
    }

    @Override
    public void doCommand() {
        writer.writeLine("waiting for connection... ");
        new Thread(new HttpServer(commandManager)).start();
    }
}
