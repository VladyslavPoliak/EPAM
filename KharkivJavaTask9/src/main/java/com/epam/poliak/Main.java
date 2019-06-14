package com.epam.poliak;

import com.epam.poliak.controller.Controller;
import com.epam.poliak.io.Reader;
import com.epam.poliak.io.Writer;
import com.epam.poliak.io.impl.ReaderImpl;
import com.epam.poliak.io.impl.WriterImpl;
import com.epam.poliak.utils.Constants;
import com.epam.poliak.utils.PrintUtils;
import com.epam.poliak.utils.ValidateUtils;

public class Main {

    public static void main(String[] args) {
        Writer writer = new WriterImpl();
        Reader reader = new ReaderImpl();
        Controller controller = new Controller(reader, writer);
        String menu = "";
        while (!menu.equals(Constants.EXIT_COMMAND)) {
            PrintUtils.printMenu();
            menu = reader.nextLine();
            if (ValidateUtils.validateEnter(menu, Constants.NUMBERS) && controller.getAllCommandMap().containsKey(Integer.parseInt(menu))
                    && Integer.parseInt(menu) <= controller.getAllCommandMap().size()) {
                controller.executeCommand(Integer.parseInt(menu));
            } else {
                writer.writeLine("Wrong command! Try again.");
            }
        }

    }
}
