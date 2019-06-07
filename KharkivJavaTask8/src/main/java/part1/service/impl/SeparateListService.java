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
        int numbersPerThread = (finish - start) / numberOfThreads;
        long startTime = 0;
        for (int i = 0; i < numberOfThreads; i++) {
            int localStart = start + i * numbersPerThread;
            FutureTask<List<Integer>> listFutureTask = new FutureTask<>(new SeparateList(localStart, localStart + numbersPerThread));
            Thread thread = new Thread(listFutureTask);
            startTime = System.currentTimeMillis();
            thread.start();
            try {
                resultList.addAll(listFutureTask.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Result time = " + (System.currentTimeMillis() - startTime) + " ms");
        resultList.forEach(System.out::println);
    }

    @Override
    public void startExecutor() {
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        List<Integer> result = new ArrayList<>();
        List<Future<List<Integer>>> futureList = new ArrayList<>();
        int numbersPerThread = (finish - start) / numberOfThreads;
        for (int i = 0; i < numberOfThreads; i++) {
            int localStart = start + i * numbersPerThread;
            Future<List<Integer>> futureTask = executor.submit(new SeparateList(localStart, localStart + numbersPerThread));
            futureList.add(futureTask);
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
                Thread.sleep(0, 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Result time = " + (System.currentTimeMillis() - startTime) + " ms");
        result.forEach(System.out::println);
    }

}
