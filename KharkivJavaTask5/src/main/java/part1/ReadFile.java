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

    public static void main(String[] args) {
        ReadFile readFile = new ReadFile("test.txt");
        readFile.printText();
    }

    @Override
    public Iterator<String> iterator() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            lines = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Iterator<String>() {
            int index;

            @Override
            public boolean hasNext() {
                return index < lines.size();
            }

            @Override
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return lines.get(index++);
            }
        };
    }

    private void printText() {
        for (Iterator iterator = iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }

}
