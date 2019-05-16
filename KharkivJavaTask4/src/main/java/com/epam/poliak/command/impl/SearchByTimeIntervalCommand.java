package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.service.OrderService;
import com.epam.poliak.utils.Constants;
import com.epam.poliak.utils.Utils;

import java.util.Scanner;

public class SearchByTimeIntervalCommand implements Command {

    private OrderService orderService;

    public SearchByTimeIntervalCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void doCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первую дату(dd.MM.yyyy)");
        String date = scanner.nextLine();
        System.out.println("Введите вторую дату(dd.MM.yyyy)");
        String date2 = scanner.nextLine();
        if (Utils.validateEnter(date, Constants.DATE) && Utils.validateEnter(date2, Constants.DATE)) {
            orderService.searchByTimeInterval(Utils.getDate(date), Utils.getDate(date2));
        }
    }
}
