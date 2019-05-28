package com.epam.poliak.utils;

import com.epam.poliak.entity.Car;
import com.epam.poliak.entity.Transport;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Utils {

    private Utils() {
    }

    public static void printMenu() {
        System.out.println();
        System.out.println(Constants.MENU);
    }

    public static boolean validateEnter(String s, String patt) {
        Pattern pattern = Pattern.compile(patt);
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            return true;
        }
        throw new InputMismatchException("Incorrect data");

    }

    public static int validateDays(int number) {
        if (number <= 0) {
            return 1;
        }
        return number;
    }

    public static Date getDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            return format.parse(date);
        } catch (ParseException e) {
            System.out.println("Incorrect data");
        }
        return new Date();
    }

    public static Date determineNearestDate(Date mainDate, Date date, Date date2) {
        long difference = date2.getTime() - mainDate.getTime();
        long difference2 = Math.abs(date.getTime() - mainDate.getTime());
        return difference > difference2 ? date : date2;
    }

    public static void getSearchResults(Map<Date, Map<Transport, Integer>> map) {
        if (map.isEmpty()) {
            System.out.println("Nothing found");
        } else {
            System.out.println(map.size() + " orders found");
            map.forEach(Utils::printMap);
        }
    }

    public static void serializableAllTransportList(String fileName) {
        ArrayList<Transport> transportList = new ArrayList<>();
        transportList.add(new Car(0, 5500, "Nissan", 200, 2011));
        transportList.add(new Car(1, 5000, "Nissan", 150, 2010));
        transportList.add(new Car(2, 6000, "Toyota", 152, 2011));
        transportList.add(new Car(3, 2000, "Mazda", 155, 2014));
        transportList.add(new Car(4, 7000, "Nissan", 140, 2013));
        FileWriter file;
        try {
            file = new FileWriter(fileName);
            String forJson = new GsonBuilder().setPrettyPrinting().create().toJson(transportList);
            file.write(forJson);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Transport> deserializableAllTransportList(String fileName) {
        Path path = Paths.get(fileName);
        ArrayList<Transport> res = null;
        try {
            List<String> allLinesFromFile = Files.readAllLines(path);
            StringBuilder builder = new StringBuilder();
            for (String line : allLinesFromFile) {
                builder.append(line);
            }
            Type targetClassType = new TypeToken<ArrayList<Transport>>() {
            }.getType();
            res = new Gson().fromJson(builder.toString(), targetClassType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    private static void printMap(Date k, Map<Transport, Integer> v) {
        v.forEach((val, key) -> System.out.println("Date: " + k + " " + val + " Rental days: " + key));
    }
}
