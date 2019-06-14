package part1_and_part2.threads;

import util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class SeparateList implements Callable<List<Integer>> {

    private int start;
    private int finish;

    public SeparateList(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public List<Integer> call() {
        List<Integer> localeList = new ArrayList<>();
        for (int i = start; i < finish; i++) {
            if (Utils.checkPrime(i)) {
                localeList.add(i);
            }
        }
        return localeList;
    }
}
