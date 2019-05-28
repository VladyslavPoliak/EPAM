package part2;

import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search by date last modified? 1/0");
        if (scanner.nextInt() == 1) {
            if (!isPastFilterWorked()) {
                list = Utils.getPath(directory);
            }
        }
        return list;
    }
}
