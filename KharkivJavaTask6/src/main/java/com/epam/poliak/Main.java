package com.epam.poliak;

import com.epam.poliak.controller.Controller;
import com.epam.poliak.utils.Constants;
import com.epam.poliak.utils.Utils;

import java.util.Scanner;

public class Main {

    private static Controller controller = new Controller();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String menu;
            while (true) {
                Utils.printMenu();
                menu = scanner.nextLine();
                if (Utils.validateEnter(menu, Constants.NUMBERS) && controller.getAllCommandMap().containsKey(Integer.parseInt(menu))
                        && Integer.parseInt(menu) <= controller.getAllCommandMap().size()) {
                    controller.executeCommand(Integer.parseInt(menu));
                } else {
                    System.out.println("Wrong command! Try again.");
                }
            }
        }
    }
}
