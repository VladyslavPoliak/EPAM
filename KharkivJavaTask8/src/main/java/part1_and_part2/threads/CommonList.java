package part1_and_part2.threads;

import util.Utils;

import java.util.List;

public class CommonList implements Runnable {

    private final List<Integer> list;
    private int start;
    private int finish;

    public CommonList(List<Integer> list, int start, int finish) {
        this.list = list;
        this.start = start;
        this.finish = finish;
    }

    @Override
    public void run() {
        for (int i = start; i < finish; i++) {
            if (Utils.checkPrime(i)) {
                synchronized (list) {
                    list.add(i);
                }
            }
        }
    }
}
