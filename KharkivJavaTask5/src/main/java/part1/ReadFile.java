package part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    private String fileName;
    private List<String> strings;

    public ReadFile(String fileName) {
        this.fileName = fileName;
        strings = new ArrayList<>();
        getStringsFromFile();
    }

    public static void main(String[] args) {
        ReadFile readFile = new ReadFile("test.txt");
        readFile.printText();
    }

    private void getStringsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String string;
            while ((string = reader.readLine()) != null) {
                strings.add(string);
            }
        } catch (IOException e) {
            System.out.println("Невозможно прочитать содержимое файла");
        }
    }

    private void printText() {
        for (String line : strings) {
            System.out.println(line);
        }
    }
}
