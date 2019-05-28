package part2;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class SizeFilter extends Filter {

    public SizeFilter(Filter nextFilter) {
        super(nextFilter);
    }

    /**
     * method to filter files by size in the specified directory
     *
     * @param list      designed to store filtered paths
     * @param directory it is used to call the method Utils.getPath(directory)
     * @return list of paths
     */

    @Override
    public List<Path> doFilter(List<Path> list, String directory) {
        System.out.println("Search by size? 1/0");
        LOGGER.info(list.size());
        if (scanner.nextInt() == 1) {
            System.out.println("enter minimum size");
            long minSize = scanner.nextLong();
            System.out.println("enter max size");
            long maxSize = scanner.nextLong();
            if (!isPastFilterWorked() && list.isEmpty()) {
                list = Utils.getPath(directory);
            }
            setPastFilterWorked(true);
            return list.stream().map(Path::toFile)
                    .filter(File::isFile)
                    .filter(f -> f.length() >= minSize && f.length() <= maxSize)
                    .map(File::toPath)
                    .collect(Collectors.toList());
        }
        LOGGER.info(list.size());
        setPastFilterWorked(false);
        return list;
    }
}

