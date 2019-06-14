package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.io.Reader;
import com.epam.poliak.io.Writer;
import com.epam.poliak.service.OrderService;
import com.epam.poliak.utils.Constants;
import com.epam.poliak.utils.DateUtils;
import com.epam.poliak.utils.PrintUtils;
import com.epam.poliak.utils.ValidateUtils;

import java.util.InputMismatchException;

public class SearchByTimeIntervalCommand implements Command {

    private OrderService orderService;
    private Reader reader;
    private Writer writer;

    public SearchByTimeIntervalCommand(Reader reader, Writer writer, OrderService orderService) {
        this.orderService = orderService;
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void doCommand() {
        try {
            writer.writeLine("Enter first date(dd.MM.yyyy)");
            String date = reader.nextLine();
            writer.writeLine("Enter second date(dd.MM.yyyy)");
            String date2 = reader.nextLine();
            if (ValidateUtils.validateEnter(date, Constants.DATE) && ValidateUtils.validateEnter(date2, Constants.DATE)) {
                PrintUtils.getSearchResults(orderService.searchByTimeInterval(DateUtils.getDate(date), DateUtils.getDate(date2)));
            }
        } catch (InputMismatchException ex) {
            writer.writeLine("Incorrect data");
            doCommand();
        }
    }
}
