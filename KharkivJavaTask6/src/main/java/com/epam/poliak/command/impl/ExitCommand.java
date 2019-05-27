package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.service.TransportService;
import com.epam.poliak.utils.SerializableTransportList;

public class ExitCommand implements Command {

    private TransportService transportService;
    private String fileName;

    public ExitCommand(TransportService transportService, String fileName) {
        this.transportService = transportService;
        this.fileName = fileName;
    }

    @Override
    public void doCommand() {
//        Utils.serializableAllTransportList("serialisation.txt");
        SerializableTransportList serializable = new SerializableTransportList(transportService);
        serializable.serializableData(fileName);
        System.exit(0);
    }
}
