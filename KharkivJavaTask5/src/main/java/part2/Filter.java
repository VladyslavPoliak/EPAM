package part2;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Filter {

    protected Scanner scanner = new Scanner(System.in);
    private Filter nextFilter;
    private List<Path> files = new ArrayList<>();
    private boolean isPastFilterWorked;

    /**
     * method for setting the next filter in the chain
     *
     * @param nextFilter following filter
     */
    public void setNextFilter(Filter nextFilter) {
        this.nextFilter = nextFilter;
    }

    /**
     * method to start the filtering process
     *
     * @param list      designed to store filtered paths
     * @param directory needed to get file paths
     */
    public List<Path> run(List<Path> list, String directory) {
        files = doFilter(list, directory);
        if (nextFilter != null) {
            files = nextFilter.run(files, directory);
        }
        return files;
    }

    /**
     * abstract method to run the filter
     *
     * @param list      designed to store filtered paths
     * @param directory needed to get file paths
     */
    public abstract List<Path> doFilter(List<Path> list, String directory);

    /**
     * method to check whether the previous filter was run in the chain
     *
     * @return {@code true} if the previous filter was started
     * {@code false} if the previous filter was skipped
     */
    public boolean isPastFilterWorked() {
        return isPastFilterWorked;
    }

    /**
     * method for setting the use of past filter in the chain
     */
    public void setPastFilterWorked(boolean isPastFilterWorked) {
        this.isPastFilterWorked = isPastFilterWorked;
    }
}
