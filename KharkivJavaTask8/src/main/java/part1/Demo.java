package part1;

import part1.service.impl.CommonListService;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter diapason of numbers" + System.lineSeparator() + "From: ");
        int start = scanner.nextInt();
        System.out.println("to: ");
        int finish = scanner.nextInt();
        System.out.println("Enter number of threads");
        int numberOfThreads = scanner.nextInt();

        CommonListService listService = new CommonListService(start, finish, numberOfThreads);
        listService.startThread();
    }

}
