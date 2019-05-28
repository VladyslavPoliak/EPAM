package part2;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class NameFilter extends Filter {

    public NameFilter(Filter nextFilter) {
        super(nextFilter);
    }

    /**
     * method to filter files by name
     *
     * @param list      designed to store filtered paths
     * @param directory needed to get file paths
     * @return list of paths
     */

    @Override
    public List<Path> doFilter(List<Path> list, String directory) {
        System.out.println("Search by name? 1/0");
        if (scanner.nextInt() == 1) {
            System.out.println("Enter name");
            String fileName = scanner.next();
            return list.stream()
                    .filter(f -> f.getFileName().toString().startsWith(fileName))
                    .collect(Collectors.toList());
        }
        LOGGER.info(list.size());
        return list;
    }
}
