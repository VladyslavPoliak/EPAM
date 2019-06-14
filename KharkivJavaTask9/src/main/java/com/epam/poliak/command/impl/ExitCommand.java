package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.service.TransportService;
import com.epam.poliak.utils.SerializableAllTransport;

public class ExitCommand implements Command {

    private TransportService transportService;
    private String fileName;

    public ExitCommand(TransportService transportService, String fileName) {
        this.transportService = transportService;
        this.fileName = fileName;
    }

    @Override
    public void doCommand() {
        new SerializableAllTransport(transportService).serializableData(fileName);
    }
}
