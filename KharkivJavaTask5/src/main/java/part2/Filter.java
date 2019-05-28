package part2;

import org.apache.log4j.Logger;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Filter {

    protected final Logger LOGGER = Logger.getLogger(getClass());
    protected Scanner scanner = new Scanner(System.in);
    private Filter nextFilter;
    private List<Path> files = new ArrayList<>();


    public Filter(Filter nextFilter) {
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
}
