package part2;

import java.util.Scanner;
import java.util.concurrent.Exchanger;

public class Main {

    private Exchanger<String> exchanger = new Exchanger<>();

    public Main() {
        FindLongestSequence findLongestSequence = new FindLongestSequence(exchanger);
       new Thread(findLongestSequence).start();
    }

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        main.startSearch();
    }

    public void startSearch() throws InterruptedException {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter File name:");
            String name=scanner.nextLine();
            System.out.println("-----------"+name);
           exchanger.exchange(name);
            while (true) {
                String infoFromOtherThread = exchanger.exchange(null);
                if (infoFromOtherThread.startsWith("Current")) {
                    System.out.println(infoFromOtherThread);
                } else {
                    System.out.println(infoFromOtherThread);
                    startSearch();
                }
            }
        }
    }
}
