package part3;

import util.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Exchanger;

public class Searcher implements Runnable {

    private byte[] allBytes;
    private int firstIndex;
    private int lastIndex;
    private int maxLength;
    private Exchanger<String> exchanger;

    public Searcher(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            readAllBytes(exchanger.exchange(null));
            startFindSequence();
            exchanger.exchange(Constants.FINAL_RESULT + getResult());
            resetSearchResults();
            run();
        } catch (InterruptedException e) {
            System.out.println(Constants.INTERRUPTED_ERROR);
        }
    }

    private synchronized void readAllBytes(String fileName) {
        try {
            allBytes = Files.readAllBytes(Paths.get(fileName));
        } catch (IOException e) {
            System.out.println(Constants.ERROR_READING_FILE);
        }
    }

    private void startFindSequence() throws InterruptedException {
        int[][] result = new int[allBytes.length][allBytes.length];
        for (int i = 0; i < allBytes.length; i++) {
            for (int j = 0; j < allBytes.length; j++) {
                findRepetitions(result, i, j);
            }
            exchanger.exchange(Constants.CURRENT_MAX_LENGTH + maxLength);
        }
    }

    private void findRepetitions(int[][] result, int i, int j) {
        if (allBytes[i] == allBytes[j]) {
            if (i != j && i != 0 && j != 0) {
                result[i][j] = result[i - 1][j - 1] + 1;
            } else {
                result[i][j] = 1;
            }
        }
        compareLengthWithOldLength(result, i, j);
    }

    private void compareLengthWithOldLength(int[][] result, int i, int j) {
        if (result[i][j] > maxLength) {
            maxLength = result[i][j];
            firstIndex = i;
            lastIndex = j;
        }
    }

    private String getResult() {
        return " First Index = " + (firstIndex - maxLength + 1) +
                ", Last Index = " + (lastIndex - maxLength + 1) +
                ", Max Length = " + maxLength;
    }

    private void resetSearchResults() {
        firstIndex = 0;
        lastIndex = 0;
        maxLength = 0;
    }
}


