package part2;

import java.io.File;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LastModifiedFilter extends Filter {

    public LastModifiedFilter(Filter nextFilter) {
        super(nextFilter);
    }

    /**
     * if the previous filter was omitted , the method gets a list of paths in the specified directory
     *
     * @return list of paths
     */

    @Override
    public List<Path> doFilter(List<Path> list, String directory) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Search by date last modified? 1/0");
            if (scanner.nextInt() == 1) {
                System.out.println("Enter first date(dd.MM.yyyy)");
                String fromDate = scanner.next();
                System.out.println("Enter second date(dd.MM.yyyy)");
                String toDate = scanner.next();
                if (Utils.checkValidateDate(fromDate, toDate)) {
                    return list.stream().map(Path::toFile)
                            .filter(file -> file.lastModified() >= Utils.getDateFromString(fromDate))
                            .filter(file -> file.lastModified() <= Utils.getDateFromString(toDate))
                            .map(File::toPath)
                            .collect(Collectors.toList());
                }
            }
        } catch (InputMismatchException ex) {
            LOGGER.error("Incorrect date");
        }
        return list;
    }
}
