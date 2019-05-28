package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.service.TransportService;

import java.util.Scanner;

public class AddNewTransport implements Command {

    private TransportService transportService;

    public AddNewTransport(TransportService transportService) {
        this.transportService = transportService;
    }

    @Override
    public void doCommand() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter price");
            int price = scanner.nextInt();
            System.out.println("Enter producer");
            String producer = scanner.next();
            transportService.addNewTransport(price, producer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
