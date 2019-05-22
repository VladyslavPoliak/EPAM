package part2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NameFilter extends Filter {

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
            try (Stream<Path> files = Files.walk(Paths.get(directory))) {
                setPastFilterWorked(true);
                return files.map(Path::toFile)
                        .filter(File::isFile)
                        .filter(f -> f.getName().startsWith(fileName))
                        .map(File::toPath)
                        .collect(Collectors.toList());
            } catch (IOException e) {
                System.out.println("Error");
            }
        }
        setPastFilterWorked(false);
        return list;
    }
}
