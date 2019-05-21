package part2;

import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class LastModifiedFilter extends Filter {

    @Override
    public List<Path> doFilter(List<Path> list, String directory) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search by date last modified? 1/0");
        if (scanner.nextInt() == 1) {

        }
        return list;
    }
}
