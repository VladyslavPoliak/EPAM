package com.epam.poliak;

import com.epam.poliak.command.RunCommand;
import com.epam.poliak.utils.Utils;

import java.util.Scanner;

public class Main {

    private static RunCommand runCommand = new RunCommand();

    public static void main(String[] args) {
        Utils.fillItemList();
        mainMenu();
    }

    private static void mainMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                Utils.printMenu();
                int menu = scanner.nextInt();
                if (menu == 6) {
                    System.exit(0);
                }
                runCommand.executeCommand(menu);
            }
        }
    }
}
