package part2;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ExtensionFilter extends Filter {

    public ExtensionFilter(Filter nextFilter) {
        super(nextFilter);
    }

    /**
     * method to filter files by extension
     *
     * @param list      designed to store filtered paths
     * @param directory it is used to call the method Utils.getPath(directory)
     * @return list of paths
     */

    @Override
    public List<Path> doFilter(List<Path> list, String directory) {
        System.out.println("Search by extension? 1/0");
        if (scanner.nextInt() == 1) {
            System.out.println("enter extension ");
            String extension = scanner.next();
            return list.stream()
                    .filter(f -> f.getFileName().toString().endsWith(extension))
                    .collect(Collectors.toList());
        }
        LOGGER.info(list.size());
        return list;
    }
}
