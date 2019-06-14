package part1_and_part2.service.impl;

import part1_and_part2.service.ThreadService;
import part1_and_part2.threads.SeparateList;
import util.Constants;

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
        List<Future<List<Integer>>> futureTasks = new ArrayList<>();

        createThreads(threadList, futureTasks);
        long startTime = System.currentTimeMillis();
        threadList.forEach(Thread::start);

        addAllToResultList(resultList, futureTasks);

        System.out.println(Constants.RESULT_TIME_FOR_SEPARATE_LIST + (System.currentTimeMillis() - startTime) + " ms");
    }


    @Override
    public void startExecutor() {
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        List<Integer> result = new ArrayList<>();
        List<Future<List<Integer>>> futureList = new ArrayList<>();
        initFutureList(executor, futureList);
        long startTime = System.currentTimeMillis();

        addAllToResultList(result, futureList);

        executor.shutdown();

        System.out.println(Constants.RESULT_TIME_FOR_SEPARATE_LIST + (System.currentTimeMillis() - startTime) + " ms");
    }

    private void createThreads(List<Thread> threads, List<Future<List<Integer>>> futureTasks) {
        int numbersPerThread = (finish - start) / numberOfThreads;
        for (int i = 0; i < numberOfThreads; i++) {
            int localStart = start + i * numbersPerThread;
            FutureTask<List<Integer>> listFutureTask = new FutureTask<>(new SeparateList(localStart, localStart + numbersPerThread));
            threads.add(new Thread(listFutureTask));
            futureTasks.add(listFutureTask);
        }
    }

    private void addAllToResultList(List<Integer> resultList, List<Future<List<Integer>>> future) {
        future.forEach(listFuture -> {
            try {
                resultList.addAll(listFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(Constants.INTERRUPTED_ERROR);
            }
        });
    }

    private void initFutureList(ExecutorService executor, List<Future<List<Integer>>> futureList) {
        int numbersPerThread = (finish - start) / numberOfThreads;
        for (int i = 0; i < numberOfThreads; i++) {
            int localStart = start + i * numbersPerThread;
            futureList.add(executor.submit(new SeparateList(localStart, localStart + numbersPerThread)));
        }
    }
}
