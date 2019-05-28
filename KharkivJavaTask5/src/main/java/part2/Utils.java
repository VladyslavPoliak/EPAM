package part2;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {

    private static final String DATE = "(0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((19|20)\\d\\d)";
    private static final Logger LOGGER = Logger.getLogger(Utils.class);
    private static List<Path> list = new ArrayList<>();

    /**
     * if the previous filter was omitted , the method gets a list of paths in the specified directory
     *
     * @param directory needed to get file paths
     * @return list of paths
     * @see Files
     */
    public static List<Path> getPath(String directory) {
        try (Stream<Path> files = Files.walk(Paths.get(directory))) {
            list = files.map(Path::toFile)
                    .filter(File::isFile)
                    .map(File::toPath)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.error("Error reading files");
        }
        return list;
    }

    public static long getDateFromString(String date) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date parseDate = format.parse(date);
            return parseDate.getTime();
        } catch (ParseException e) {
            LOGGER.error("Incorrect date");
        }
        return new Date().getTime();
    }

    public static boolean checkValidateDate(String date, String date2) {
        Pattern pattern = Pattern.compile(DATE);
        Matcher matcher = pattern.matcher(date);
        Matcher matcher2 = pattern.matcher(date2);
        if (matcher.find() && matcher2.find()) {
            return true;
        }
        throw new InputMismatchException("Incorrect date");

    }
}
