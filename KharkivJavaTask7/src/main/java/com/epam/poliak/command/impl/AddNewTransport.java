package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.creator.ChooseCreator;
import com.epam.poliak.input.InputHelper;
import com.epam.poliak.service.TransportService;
import com.epam.poliak.utils.Constants;

import java.util.Scanner;

public class AddNewTransport implements Command {

    private InputHelper helper;

    private TransportService transportService;

    public AddNewTransport(TransportService transportService, InputHelper helper) {
        this.transportService=transportService;
        this.helper = helper;
    }

    @Override
    public void doCommand() {
        System.out.println(Constants.ADD_NEW_TRANSPORT_MENU);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Transport");
        transportService.addNewTransport(new ChooseCreator(helper).doCreate(scanner.next()));
        System.out.println("Successfully added!");
    }
}
