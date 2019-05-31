package com.epam.poliak.input;

import java.util.Random;
import java.util.Scanner;

public interface InputHelper {

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    Integer getInteger(String ms);

    String getString(String ms);

}
