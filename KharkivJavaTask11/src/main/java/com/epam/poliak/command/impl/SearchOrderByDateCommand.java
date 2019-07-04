package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.io.Reader;
import com.epam.poliak.io.Writer;
import com.epam.poliak.service.OrderService;
import com.epam.poliak.utils.Constants;
import com.epam.poliak.utils.DateUtils;
import com.epam.poliak.utils.ValidateUtils;

import java.util.InputMismatchException;

public class SearchOrderByDateCommand implements Command {

    private OrderService orderService;
    private Reader reader;
    private Writer writer;

    public SearchOrderByDateCommand(Reader reader, Writer writer, OrderService orderService) {
        this.orderService = orderService;
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void doCommand() {
        try {
            writer.writeLine("Enter a date to search(dd.MM.yyyy)");
            String date = reader.nextLine();
            if (ValidateUtils.validateEnter(date, Constants.DATE)) {
                writer.writeLine(orderService.findOrderByDate(DateUtils.getDate(date)));
            }
        } catch (InputMismatchException ex) {
            writer.writeLine("Incorrect data");
            doCommand();
        }
    }
}