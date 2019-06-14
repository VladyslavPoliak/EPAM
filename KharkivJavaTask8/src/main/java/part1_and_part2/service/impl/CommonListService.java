package part1_and_part2.service.impl;

import part1_and_part2.service.ThreadService;
import part1_and_part2.threads.CommonList;
import util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CommonListService implements ThreadService {

    private int start;
    private int finish;
    private int numberOfThreads;

    public CommonListService(int start, int finish, int numberOfThreads) {
        this.start = start;
        this.finish = finish;
        this.numberOfThreads = numberOfThreads;
    }

    @Override
    public void startThread() {
        List<Thread> threadList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        createThreads(threadList, result);

        threadList.forEach(Thread::start);
        long startTime = System.currentTimeMillis();
        joinThreads(threadList);

        System.out.println(Constants.RESULT_TIME_FOR_COMMON_LIST + (System.currentTimeMillis() - startTime) + " ms");
    }

    @Override
    public void startExecutor() {
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        List<Thread> threadList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        createThreads(threadList, result);
        threadList.forEach(executor::submit);
        long startTime = System.currentTimeMillis();
        executor.shutdown();
        checkTerminated(executor);
        System.out.println(Constants.RESULT_TIME_FOR_COMMON_LIST + (System.currentTimeMillis() - startTime) + " ms");
    }

    private void createThreads(List<Thread> threads, List<Integer> result) {
        int numbersPerThread = (finish - start) / numberOfThreads;
        for (int i = 0; i < numberOfThreads; i++) {
            int localStart = start + i * numbersPerThread;
            Thread thread = new Thread(new CommonList(result, localStart, localStart + numbersPerThread));
            threads.add(thread);
        }
    }

    private void joinThreads(List<Thread> threads) {
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(Constants.INTERRUPTED_ERROR);
            }
        });
    }

    private void checkTerminated(ExecutorService executor) {
        while (!executor.isTerminated()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(Constants.INTERRUPTED_ERROR);
            }
        }
    }
}
