package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.service.OrderService;
import com.epam.poliak.utils.Constants;
import com.epam.poliak.utils.Utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SearchByTimeIntervalCommand implements Command {

    private OrderService orderService;

    public SearchByTimeIntervalCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void doCommand() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter first date(dd.MM.yyyy)");
            String date = scanner.nextLine();
            System.out.println("Enter second date(dd.MM.yyyy)");
            String date2 = scanner.nextLine();
            if (Utils.validateEnter(date, Constants.DATE) && Utils.validateEnter(date2, Constants.DATE)) {
                Utils.getSearchResults(orderService.searchByTimeInterval(Utils.getDate(date), Utils.getDate(date2)));
            }
        } catch (InputMismatchException ex) {
            System.out.println("Incorrect data");
            doCommand();
        }
    }
}
