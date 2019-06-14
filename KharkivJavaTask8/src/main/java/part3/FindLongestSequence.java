package part3;

import util.Constants;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.Exchanger;

public class FindLongestSequence {

    private Exchanger<String> exchanger = new Exchanger<>();

    public FindLongestSequence() {
        Searcher searcher = new Searcher(exchanger);
        new Thread(searcher).start();
    }

    public void startSearch() throws InterruptedException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(Constants.ENTER_FILE_NAME);
            String fileName = scanner.nextLine();
            checkFileNameEntered(fileName);
            exchanger.exchange(fileName);
            while (true) {
                communicationWithAnotherThread();
            }
        }
    }

    private void checkFileNameEntered(String fileName) throws InterruptedException {
        if (!new File(fileName).isFile()) {
            System.out.println(Constants.NO_SUCH_FILE_EXISTS);
            startSearch();
        }
    }

    private void communicationWithAnotherThread() throws InterruptedException {
        String infoFromOtherThread = exchanger.exchange(null);
        if (infoFromOtherThread.startsWith(Constants.INTERMEDIATE_RESULT)) {
            System.out.println(infoFromOtherThread);
        } else {
            System.out.println(infoFromOtherThread);
            startSearch();
        }
    }
}
