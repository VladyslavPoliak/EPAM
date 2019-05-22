package part2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {

    private static List<Path> list = new ArrayList<>();

    public static List<Path> getPath(String directory) {
        try (Stream<Path> files = Files.walk(Paths.get(directory))) {
            list = files.map(Path::toFile)
                    .filter(File::isFile)
                    .map(File::toPath)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Error");
        }
        return list;
    }
}
