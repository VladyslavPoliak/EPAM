package com.epam.poliak;

import com.epam.poliak.command.RunCommand;

import java.util.Scanner;

public class Main {

    private static RunCommand runCommand = new RunCommand();

    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                printMenu();
                int menu = scanner.nextInt();
                if (menu == 6) {
                    System.exit(0);
                }
                runCommand.executeCommand(menu);
            }
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println(Constants.DISPLAY_ALL_CARS);
        System.out.println(Constants.ADD_CAR_TO_CART);
        System.out.println(Constants.VIEW_CART);
        System.out.println(Constants.CHECKOUT);
        System.out.println(Constants.VIEW_INFORMATION);
        System.out.println(Constants.EXIT);
    }
}
