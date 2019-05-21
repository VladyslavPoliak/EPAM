package part2;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public abstract class Filter {

    private Filter nextFilter;
    private List<Path> files = new ArrayList<>();

    public void setNextFilter(Filter nextFilter) {
        this.nextFilter = nextFilter;
    }

    public List<Path> run(List<Path> list, String directory) {
        files = doFilter(list, directory);
        if (nextFilter != null) {
            nextFilter.run(files, directory);
        }
        return files;
    }

    public abstract List<Path> doFilter(List<Path> list, String directory);
}
