package com.epam.poliak;

import com.epam.poliak.command.Controller;
import com.epam.poliak.utils.Constants;
import com.epam.poliak.utils.Utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static Controller controller = new Controller();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String menu;
            while (true) {
                Utils.printMenu();
                menu = scanner.nextLine();
                Pattern pattern = Pattern.compile(Constants.NUMBERS);
                Matcher matcher = pattern.matcher(menu);
                if (matcher.find() && controller.getAllCommandMap().containsKey(Integer.parseInt(menu))) {
                    controller.executeCommand(Integer.parseInt(menu));
                } else {
                    System.out.println("Wrong command! Try again.");
                }
            }
        }
    }
}
