package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.creator.ReflectionCreator;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.input.InputHelper;
import com.epam.poliak.io.Reader;
import com.epam.poliak.io.Writer;
import com.epam.poliak.service.TransportService;
import com.epam.poliak.utils.Constants;

import java.util.ResourceBundle;

public class AddNewTransportReflection implements Command {

    private Reader reader;
    private Writer writer;
    private InputHelper inputHelper;
    private TransportService transportService;
    private ResourceBundle bundle;
    private ReflectionCreator creator;

    public AddNewTransportReflection(Reader reader, Writer writer, TransportService transportService, InputHelper inputHelper, ResourceBundle bundle) {
        this.reader = reader;
        this.writer = writer;
        this.inputHelper = inputHelper;
        this.transportService = transportService;
        this.bundle = bundle;
        creator = new ReflectionCreator(writer);
    }

    @Override
    public void doCommand() {
        writer.writeLine(Constants.ADD_NEW_TRANSPORT_MENU);
        writer.writeLine("Choose Transport");
        Transport transport = creator.create(reader.nextLine(), bundle, inputHelper);
        transportService.addNewTransport(transport);
    }
}
