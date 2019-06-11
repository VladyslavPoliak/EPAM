package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.service.OrderService;
import com.epam.poliak.utils.Constants;
import com.epam.poliak.utils.DateUtils;
import com.epam.poliak.utils.ValidateUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SearchOrderByDateCommand implements Command {

    private OrderService orderService;

    public SearchOrderByDateCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void doCommand() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter a date to search(dd.MM.yyyy)");
            String date = scanner.nextLine();
            if (ValidateUtils.validateEnter(date, Constants.DATE)) {
                System.out.println(orderService.findOrderByDate(DateUtils.getDate(date)));
            }
        } catch (InputMismatchException ex) {
            System.out.println("Incorrect data");
            doCommand();
        }
    }
}