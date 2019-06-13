package part1.service.impl;

import part1.service.ThreadService;
import part1.threads.CommonList;

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
        int numbersPerThread = (finish - start) / numberOfThreads;

        for (int i = 0; i < numberOfThreads; i++) {
            int localStart = start + i * numbersPerThread;
            Thread thread = new Thread(new CommonList(result, localStart, localStart + numbersPerThread));
            threadList.add(thread);
        }

        threadList.forEach(Thread::start);
        long startTime = System.currentTimeMillis();
        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("the thread was interrupted");
            }
        });

        System.out.println("Common list. Result time = " + (System.currentTimeMillis() - startTime) + " ms");

//        Collections.sort(result);
//        result.forEach(System.out::println);
    }

    @Override
    public void startExecutor() {
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        List<Thread> threadList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int numbersPerThread = (finish - start) / numberOfThreads;
        for (int i = 0; i < numberOfThreads; i++) {
            int localStart = start + i * numbersPerThread;
            threadList.add(new Thread(new CommonList(result, localStart, localStart + numbersPerThread)));
        }

        long startTime = System.currentTimeMillis();
        threadList.forEach(executor::submit);

        executor.shutdown();
        while (!executor.isTerminated()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Common list(Executor). Result time = " + (System.currentTimeMillis() - startTime) + " ms");
//        Collections.sort(result);
//        result.forEach(System.out::println);
    }
}
