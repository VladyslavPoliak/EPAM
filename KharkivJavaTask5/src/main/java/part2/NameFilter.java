package part2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NameFilter extends Filter {

    @Override
    public List<Path> doFilter(List<Path> list, String directory) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name");
        String fileName = scanner.nextLine();
        try (Stream<Path> files = Files.walk(Paths.get(directory))) {
            list = files.map(Path::toFile)
                    .filter(File::isFile)
                    .filter(f -> f.getName().startsWith(fileName))
                    .map(File::toPath)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Error");
        }
        return list;
    }
}
