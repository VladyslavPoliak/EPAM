package part2;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Filter {

    protected Scanner scanner = new Scanner(System.in);
    private Filter nextFilter;
    private List<Path> files = new ArrayList<>();
    private boolean pastFilter;

    public void setNextFilter(Filter nextFilter) {
        this.nextFilter = nextFilter;
    }

    public List<Path> run(List<Path> list, String directory) {
        files = doFilter(list, directory);
        if (nextFilter != null) {
            files = nextFilter.run(files, directory);
        }
        return files;
    }

    public abstract List<Path> doFilter(List<Path> list, String directory);

    public boolean isPastFilterWorked() {
        return pastFilter;
    }

    public void setPastFilter(boolean pastFilter) {
        this.pastFilter = pastFilter;
    }
}
