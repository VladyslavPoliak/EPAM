package part1;

import part1.service.impl.CommonListService;
import part1.service.impl.SeparateListService;

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

        CommonListService commonListService = new CommonListService(start, finish, numberOfThreads);
        SeparateListService separateListService = new SeparateListService(start, finish, numberOfThreads);

        commonListService.startThread();
//        separateListService.startThread();

        commonListService.startExecutor();
//        separateListService.startExecutor();
    }

}
