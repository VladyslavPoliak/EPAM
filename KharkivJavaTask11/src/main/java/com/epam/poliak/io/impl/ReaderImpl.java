package com.epam.poliak.io.impl;

import com.epam.poliak.io.Reader;

import java.util.Scanner;

public class ReaderImpl implements Reader {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }

    @Override
    public int nextInt() {
        int i = scanner.nextInt();
        scanner.nextLine();
        return i;
    }
}
