package part1.service.impl;

import part1.service.ThreadService;

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

    }

    @Override
    public void startExecutor() {

    }
}
