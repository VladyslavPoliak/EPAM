package part3;

import util.Constants;

public class Demo {

    public static void main(String[] args) {
        FindLongestSequence findLongestSequence = new FindLongestSequence();
        try {
            findLongestSequence.startSearch();
        } catch (InterruptedException e) {
            System.out.println(Constants.INTERRUPTED_ERROR);
        }
    }

}
