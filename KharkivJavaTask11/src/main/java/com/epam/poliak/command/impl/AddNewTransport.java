package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.creator.ChooseCreator;
import com.epam.poliak.input.InputHelper;
import com.epam.poliak.io.Reader;
import com.epam.poliak.io.Writer;
import com.epam.poliak.service.TransportService;
import com.epam.poliak.utils.Constants;

public class AddNewTransport implements Command {

    private TransportService transportService;
    private ChooseCreator creator;
    private Reader reader;
    private Writer writer;

    public AddNewTransport(Reader reader, Writer writer, TransportService transportService, InputHelper helper) {
        this.transportService = transportService;
        this.reader = reader;
        this.writer = writer;
        creator = new ChooseCreator(writer, helper);
    }

    @Override
    public void doCommand() {
        writer.writeLine(Constants.ADD_NEW_TRANSPORT_MENU);
        writer.writeLine("Choose Transport");
        transportService.addNewTransport(creator.doCreate(reader.nextLine()));
        writer.writeLine("Successfully added!");
    }
}