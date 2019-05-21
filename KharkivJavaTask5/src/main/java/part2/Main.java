package part2;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Path> list = new ArrayList<>();

        System.out.println("Search on the desktop? 1/0");
        int menu = scanner.nextInt();
        String directory = "C:" + File.separator
                + "Users" + File.separator
                + "Vladyslav_Poliak" + File.separator
                + "Desktop";
        if (menu == 0) {
            System.out.println("Enter directory");
            directory = scanner.next();
        }

        Filter nameFilter = new NameFilter();
        Filter sizeFilter = new SizeFilter();
        Filter extensionFilter = new ExtensionFilter();

        nameFilter.setNextFilter(sizeFilter).setNextFilter(extensionFilter);

        System.out.println("Search by name? 1/0");
        menu = scanner.nextInt();
        list = nameFilter.run(list, menu, directory);
        System.out.println("was found: " + list.size());

        System.out.println("Search by size? 1/0");
        menu = scanner.nextInt();
        list = nameFilter.run(list, menu, directory);
        System.out.println("was found: " + list.size());

        System.out.println("Search by extension? 1/0");
        menu = scanner.nextInt();
        list = nameFilter.run(list, menu, directory);

        System.out.println("was found: " + list.size());

        list.forEach(System.out::println);


    }
}
