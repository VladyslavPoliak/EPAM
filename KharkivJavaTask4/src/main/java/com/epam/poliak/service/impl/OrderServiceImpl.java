package com.epam.poliak.service.impl;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.OrderService;
import com.epam.poliak.utils.Constants;
import com.epam.poliak.utils.Utils;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {

    private static Logger LOG = Logger.getLogger(OrderServiceImpl.class);
    private Map<String, Map<Transport, Integer>> orders = new TreeMap<>();

    @Override
    public boolean makeOrder(Map<Transport, Integer> hashMap) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату(DD.MM.YYYY)");
        String date = scanner.nextLine();
        if (Utils.validateEnter(date, Constants.DATE)) {
            orders.put(date, hashMap);
            return true;
        }
        System.out.println("Неправильная дата");
        return false;
    }

    @Override
    public void showAllOrders() {
        if (!orders.isEmpty()) {
            orders.forEach(this::print);
        } else {
            System.out.println("Заказы отсутствуют");
        }
    }

    @Override
    public void findOrderByDate(String date) {
        if (Utils.validateEnter(date, Constants.DATE)) {
            orders = orders.entrySet().stream()
                    .filter(ord -> ord.getKey().equals(date))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        } else {
            System.out.println("Неправильная дата");
        }
    }

    private void print(String k, Map<Transport, Integer> v) {
        v.forEach((val, key) -> System.out.println("Date: " + k + val + key));
    }

}
