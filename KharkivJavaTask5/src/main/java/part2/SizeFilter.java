package part2;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class SizeFilter extends Filter {

    @Override
    public List<Path> doFilter(List<Path> list, String directory) {
        System.out.println("Search by size? 1/0");
        if (scanner.nextInt() == 1) {
            System.out.println("enter minimum size");
            long minSize = scanner.nextLong();
            System.out.println("enter max size");
            long maxSize = scanner.nextLong();
            if (!isPastFilterWorked()) {
                list = Utils.getPath(directory);
            }
            setPastFilter(true);
            return list.stream().map(Path::toFile)
                    .filter(File::isFile)
                    .filter(f -> f.length() >= minSize && f.length() <= maxSize)
                    .map(File::toPath)
                    .collect(Collectors.toList());
        }
        setPastFilter(false);
        return list;
    }
}

