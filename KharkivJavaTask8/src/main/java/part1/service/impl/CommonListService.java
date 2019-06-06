package part1.service.impl;

import part1.service.ThreadService;
import part1.threads.CommonList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommonListService implements ThreadService {

    private int from;
    private int finish;
    private int numberOfThreads;

    public CommonListService(int from, int finish, int numberOfThreads) {
        this.from = from;
        this.finish = finish;
        this.numberOfThreads = numberOfThreads;
    }

    @Override
    public void startThread() {
        List<Thread> threadList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int numbersPerThread = (finish - from) / numberOfThreads;

        for (int i = 0; i < numberOfThreads; i++) {
            int localStart = from + i * numbersPerThread;

            Thread thread = new Thread(new CommonList(result, localStart, localStart + numbersPerThread));
            threadList.add(thread);
        }
        for (Thread thread : threadList) {
            thread.start();
        }
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Collections.sort(result);
        result.forEach(System.out::println);
    }

    @Override
    public void startExecutor() {

    }
}
