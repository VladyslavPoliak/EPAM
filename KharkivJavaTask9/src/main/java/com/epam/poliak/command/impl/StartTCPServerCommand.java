package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.utils.Constants;
import task9.server.Server;
import task9.wedCommand.WebCommandManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class StartTCPServerCommand implements Command {

    private WebCommandManager commandManager;

    public StartTCPServerCommand(WebCommandManager commandManager) {
        this.commandManager = commandManager;
    }

    @Override
    public void doCommand() {
        try (ServerSocket serverSocket = new ServerSocket(Constants.PORT)) {
            Socket socket = serverSocket.accept();
            new Thread(new Server(socket, commandManager)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
