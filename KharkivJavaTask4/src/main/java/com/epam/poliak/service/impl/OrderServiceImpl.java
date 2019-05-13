package com.epam.poliak.service.impl;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.OrderService;
import com.epam.poliak.utils.Constants;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderServiceImpl implements OrderService {

    private Map<String, Map> orders = new TreeMap<>();

    @Override
    public void makeOrder(Map<Transport, Integer> HashMap) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату(DD.MM.YYYY)");
        String date = scanner.nextLine();
        if (checkDate(date)) {
            orders.put(date, HashMap);
        } else {
            System.out.println("Неправильная дата");
        }
    }

    @Override
    public void showAllOrders() {
        if (!orders.isEmpty()) {
            orders.forEach(this::print);
        } else {
            System.out.println("Заказы отсутствуют");
        }
    }

    private void print(String k, Map<Transport, Integer> v) {
        v.forEach((val, key) -> System.out.println("Date: " + k + val + key));
    }

    private boolean checkDate(String date) {
        Pattern pattern = Pattern.compile(Constants.DATE);
        Matcher matcher = pattern.matcher(date);
        return matcher.find();
    }
}
