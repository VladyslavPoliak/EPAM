package part2;

import java.util.Scanner;

public class Main {

    private FindLongestSequence findLongestSequence;
    private Thread thread;

    public Main() {
        findLongestSequence = new FindLongestSequence();
        this.thread = new Thread(findLongestSequence);
    }

    public void startSearch() {
        thread.start();
        String fileName;
        try (Scanner scanner = new Scanner(System.in)) {
            while (!(fileName = scanner.nextLine()).equals("exit")) {
                findLongestSequence.readAllBytes(fileName);
                findLongestSequence.startSearch();
            }
        }
    }

    public static void main(String[] args) {
        Main main=new Main();
        main.startSearch();
    }
}
