package part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Exchanger;

public class FindLongestSequence implements Runnable {

    private byte[] allBytes;
    private int firstIndex;
    private int lastIndex;
    private int maxLength;
    private Exchanger<String> exchanger;

    public FindLongestSequence(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            readAllBytes(exchanger.exchange(null));
            findSequence();
            exchanger.exchange("Result of search: " + getResult());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void readAllBytes(String fileName) {
        try {
            allBytes = Files.readAllBytes(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findSequence() throws InterruptedException {
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
            exchanger.exchange("Current max Length = " + maxLength);
        }
    }

    private String getResult() {
        return " First Index= " + (firstIndex - maxLength + 1) +
                " Last Index= " + (lastIndex - maxLength + 1) +
                " Max Length= " + maxLength;

    }
}


