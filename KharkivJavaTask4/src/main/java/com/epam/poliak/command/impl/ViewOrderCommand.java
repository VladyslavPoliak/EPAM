package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.service.OrderService;

import java.util.Scanner;

public class ViewOrderCommand implements Command {

    private OrderService orderService;

    public ViewOrderCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void doCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату для поиска");
        String date = scanner.nextLine();
        orderService.findOrderByDate(date);
    }
}
