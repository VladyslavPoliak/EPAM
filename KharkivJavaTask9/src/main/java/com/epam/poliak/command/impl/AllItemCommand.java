package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.io.Writer;
import com.epam.poliak.service.TransportService;

import java.util.ArrayList;

public class AllItemCommand implements Command {

    private TransportService transportService;
    private Writer writer;

    public AllItemCommand(Writer writer, TransportService transportService) {
        this.transportService = transportService;
        this.writer = writer;
    }

    @Override
    public void doCommand() {
        ArrayList<Transport> allTransport = transportService.getAllTransport();
        if (!allTransport.isEmpty()) {
            allTransport.forEach(transport -> writer.writeLine(transport));
        } else {
            writer.writeLine("Sorry, there are no cars at the moment. Try later");
        }
    }
}
