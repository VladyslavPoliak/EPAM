package part2;

import org.apache.log4j.Logger;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    /**
     * method that creates filters and establishes a chain of duties and outputs the result of the filtration
     *
     * @param args Unused.
     * @return Nothing.
     * @see Filter
     * @see NameFilter
     * @see SizeFilter
     * @see ExtensionFilter
     * @see LastModifiedFilter
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Search on the desktop? 1/0");
            int menu = scanner.nextInt();
            String directory = "C:" + File.separator
                    + "Users" + File.separator
                    + System.getProperty("user.name") + File.separator
                    + "Desktop";
            if (menu == 0) {
                System.out.println("Enter directory");
                directory = scanner.next();
            }
            List<Path> list = Utils.getPath(directory);

            Filter nameFilter = new NameFilter(new SizeFilter(new ExtensionFilter(null)));

            list = nameFilter.run(list, directory);

            System.out.println("was found: " + list.size());

            list.forEach(System.out::println);

        } catch (InputMismatchException e) {
            LOGGER.error("Incorrect data ");
        }
    }
}
