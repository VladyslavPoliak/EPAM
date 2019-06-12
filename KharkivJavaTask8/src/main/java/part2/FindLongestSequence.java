package part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FindLongestSequence implements Runnable {

    private byte[] allBytes;
    private int firstIndex = 0;
    private int lastIndex = 0;
    private volatile int maxLength = 1;

    @Override
    public synchronized void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
            findSequence();
        }
    }

    public synchronized void startSearch() {
        notify();
    }

    public synchronized void readAllBytes(String fileName) {
        try {
            allBytes = Files.readAllBytes(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findSequence() {
        int[][] result = new int[allBytes.length][allBytes.length];
        for (int i = 0; i < allBytes.length; i++) {
            for (int j = 0; j < allBytes.length; j++) {
                if (allBytes[i] == allBytes[j]) {
                    if (i != j && i != 0 && j != 0) {
                        result[i][j] = result[i - 1][j - 1] + 1;
                    } else {
                        result[i][j] = 1;
                    }
                    if (result[i][j] > maxLength) {
                        maxLength = result[i][j];
                        firstIndex = i;
                        lastIndex = j;
                    }
                }
            }
        }
        System.out.println(getFirstIndex());
        System.out.println(getLastIndex());
        System.out.println(maxLength);
    }

    int getFirstIndex() {
        return firstIndex - maxLength + 1;
    }

    int getLastIndex() {
        return lastIndex -maxLength + 1;
    }
}


