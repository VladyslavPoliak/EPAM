package part2;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ExtensionFilter extends Filter {

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
            if (!isPastFilterWorked()) {
                list = Utils.getPath(directory);
            }

            System.out.println("enter extension ");
            String extension = scanner.next();
            setPastFilterWorked(true);
            return list.stream().map(Path::toFile)
                    .filter(File::isFile)
                    .filter(f -> f.getName().endsWith(extension))
                    .map(File::toPath)
                    .collect(Collectors.toList());
        }
        setPastFilterWorked(false);
        return list;
    }
}
