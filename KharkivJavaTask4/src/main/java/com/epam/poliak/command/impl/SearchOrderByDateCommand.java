package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.service.OrderService;
import com.epam.poliak.utils.Constants;
import com.epam.poliak.utils.Utils;

import java.util.Scanner;

public class SearchOrderByDateCommand implements Command {

    private OrderService orderService;

    public SearchOrderByDateCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void doCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату для поиска(dd.MM.yyyy)");
        String date = scanner.nextLine();
        if (Utils.validateEnter(date, Constants.DATE)) {
            orderService.findOrderByDate(Utils.getDate(date));
        }
    }
}
