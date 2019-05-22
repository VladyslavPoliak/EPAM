package part2;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
                List<Path> list = new ArrayList<>();
                System.out.println("Search on the desktop? 1/0");
                int menu = scanner.nextInt();
                String directory = "C:" + File.separator
                        + "Users" + File.separator
                        + "vlado" + File.separator
                        + "Desktop";
                if (menu == 0) {
                    System.out.println("Enter directory");
                    directory = scanner.next();
                }
                Filter nameFilter = new NameFilter();
                Filter sizeFilter = new SizeFilter();
                Filter extensionFilter = new ExtensionFilter();
                Filter lastModifiedFilter = new LastModifiedFilter();

                nameFilter.setNextFilter(sizeFilter);
                sizeFilter.setNextFilter(extensionFilter);
                extensionFilter.setNextFilter(lastModifiedFilter);
                list = nameFilter.run(list, directory);

                System.out.println("was found: " + list.size());

                list.forEach(System.out::println);

        } catch (InputMismatchException e) {
            System.out.println("Incorrect data ");
        }
    }
}
