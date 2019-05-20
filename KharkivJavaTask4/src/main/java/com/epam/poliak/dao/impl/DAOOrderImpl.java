package com.epam.poliak.dao.impl;

import com.epam.poliak.dao.DAOOrder;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.utils.Constants;
import com.epam.poliak.utils.Utils;

import java.util.*;
import java.util.stream.Collectors;

public class DAOOrderImpl implements DAOOrder {

    private Map<Date, Map<Transport, Integer>> orders;
    private Scanner scanner = new Scanner(System.in);

    public DAOOrderImpl() {
        this.orders = new TreeMap<>();
    }

    @Override
    public boolean makeOrder(Map<Transport, Integer> hashMap) {
        System.out.println("Введите дату(dd.MM.yyyy)");
        String date = scanner.nextLine();
        if (Utils.validateEnter(date, Constants.DATE)) {
            orders.put(Utils.getDate(date), new HashMap<>(hashMap));
            return true;
        }
        System.out.println("Неправильная дата");
        return false;
    }

    @Override
    public void findOrderByDate(Date date) {
        orders = orders.entrySet().stream()
                .filter(ord -> ord.getKey().equals(date))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        orders.forEach(this::print);
    }

    @Override
    public void findOrderByNearestDate(Date date) {
        Map<Date, Map<Transport, Integer>> nearestMap = new HashMap<>();
        Date before = Utils.getBeforeDate(orders, date);
        Date after = Utils.getAfterDate(orders, date);
        if (Objects.nonNull(before)) {
            nearestMap.put(before, orders.get(before));
        }
        if (Objects.nonNull(after)) {
            nearestMap.put(after, orders.get(after));
        }
        nearestMap.forEach(this::print);
    }

    @Override
    public void searchByTimeInterval(Date firstDate, Date secondDate) {
        Map<Date, Map<Transport, Integer>> intervalMap = orders.entrySet().stream()
                .filter((k) -> k.getKey().after(firstDate) && k.getKey().before(secondDate))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        intervalMap.forEach(this::print);
    }

    private void print(Date k, Map<Transport, Integer> v) {
        v.forEach((val, key) -> System.out.println("Date: " + k + " " + val + " Rental days: " + key));
    }
}
