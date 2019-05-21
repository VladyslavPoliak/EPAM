package part2;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public abstract class Filter {

    private Filter nextFilter;
    private List<Path> files;

    public Filter() {
        files = new ArrayList<>();
    }

    public Filter setNextFilter(Filter nextFilter) {
        this.nextFilter = nextFilter;
        return nextFilter;
    }

    public List<Path> run(List<Path> list, int menu, String directory) {
        if (menu == 1) {
            files = doFilter(list, directory);
        }
        if (nextFilter != null && menu == 0) {
             nextFilter.run(files, menu, directory);
        }
        return files;
    }

    public abstract List<Path> doFilter(List<Path> list, String directory);
}
