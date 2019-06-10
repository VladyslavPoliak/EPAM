package part1.service.impl;

import part1.service.ThreadService;
import part1.threads.SeparateList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SeparateListService implements ThreadService {

    private int start;
    private int finish;
    private int numberOfThreads;

    public SeparateListService(int start, int finish, int numberOfThreads) {
        this.start = start;
        this.finish = finish;
        this.numberOfThreads = numberOfThreads;
    }

    @Override
    public void startThread() {
        List<Integer> resultList = new ArrayList<>();
        List<Thread> threadList = new ArrayList<>();
        List<FutureTask<List<Integer>>> futureTasks = new ArrayList<>();
        int numbersPerThread = (finish - start) / numberOfThreads;
        int offset = 0;
        for (int i = 0; i < numberOfThreads; i++) {
            FutureTask<List<Integer>> listFutureTask = new FutureTask<>(new SeparateList(offset, offset + numbersPerThread));
            offset += numbersPerThread;
            threadList.add(new Thread(listFutureTask));
            futureTasks.add(listFutureTask);
        }
        long startTime = System.currentTimeMillis();
        threadList.forEach(Thread::start);
        futureTasks.forEach(futureTask -> {
            try {
                resultList.addAll(futureTask.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Separate list. Result time = " + (System.currentTimeMillis() - startTime) + " ms");
        resultList.forEach(System.out::println);
    }


    @Override
    public void startExecutor() {
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        List<Integer> result = new ArrayList<>();
        List<Future<List<Integer>>> futureList = new ArrayList<>();
        int numbersPerThread = (finish - start) / numberOfThreads;
        int offset = 0;
        for (int i = 0; i < numberOfThreads; i++) {
            Future<List<Integer>> future = executor.submit(new SeparateList(offset, offset + numbersPerThread));
            offset += numbersPerThread;
            futureList.add(future);
        }
        long startTime = System.currentTimeMillis();
        futureList.forEach(future -> {
            try {
                result.addAll(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        executor.shutdown();
        while (!executor.isTerminated()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Separate list(Executor).Result time = " + (System.currentTimeMillis() - startTime) + " ms");
        result.forEach(System.out::println);
    }

}
