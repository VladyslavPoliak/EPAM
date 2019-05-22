package part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ReadFile implements Iterable {

    private String fileName;
    private List<String> lines;

    public ReadFile(String fileName) {
        this.fileName = fileName;
    }

    /**
     * method that creates an object to read the file and print it line by line
     *
     * @param args Unused.
     * @return Nothing.
     */
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile("test.txt");
        readFile.printText();
    }

    /**
     * method to read the entire file and write rows to the list
     *
     * @return iterator .
     */
    @Override
    public Iterator<String> iterator() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            lines = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Error reading file. Try again");
        }
        return new Iterator<String>() {
            int index;

            /**
             * method to check for the next row in the list
             *
             * @return  {@code true} if the following line exists in the list
             *          {@code false}  if the next line is not in the list
             */
            @Override
            public boolean hasNext() {
                return index < lines.size();
            }

            /**
             * method for retrieving a row from the entire list of rows
             *
             * @return line from the list
             */
            @Override
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return lines.get(index++);
            }
        };
    }


    /**
     * method for printing a list line by line
     */
    private void printText() {
        for (Iterator iterator = iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }

}
