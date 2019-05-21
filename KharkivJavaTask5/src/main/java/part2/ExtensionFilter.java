package part2;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ExtensionFilter extends Filter {

    @Override
    public List<Path> doFilter(List<Path> list, String directory) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search by extension? 1/0");
        if (scanner.nextInt() == 1) {
            System.out.println("enter extension ");
            String extension = scanner.next();
            list = list.stream().map(Path::toFile)
                    .filter(File::isFile)
                    .filter(f -> f.getName().endsWith(extension))
                    .map(File::toPath)
                    .collect(Collectors.toList());
        }
        return list;
    }
}
