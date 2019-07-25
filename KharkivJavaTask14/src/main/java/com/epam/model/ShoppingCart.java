package com.epam.model;

import com.epam.constans.Constants;
import com.epam.entity.Car;
import com.epam.entity.OrderItem;
import com.epam.exception.ValidationException;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = -4901687745779053332L;
    private static Logger LOGGER = Logger.getLogger(ShoppingCart.class);
    private int totalCount = 0;
    private BigDecimal totalCost = BigDecimal.ZERO;
    private Map<Integer, OrderItem> cars = new LinkedHashMap<>();

    public void addCar(Car car, int count) {
        validateSize(car.getId());
        OrderItem orderItem = cars.get(car.getId());
        if (orderItem == null) {
            orderItem = new OrderItem(car, count);
            cars.put(car.getId(), orderItem);
        }
        refreshStatistics();
    }

    public int update(int id, int days) {
        OrderItem orderItem = cars.get(id);
        return orderItem.getCar().getCost() * days;
    }

    public void removeCar(int idCar) {
        OrderItem orderItem = cars.get(idCar);
        if (orderItem != null) {
                cars.remove(idCar);
            refreshStatistics();
        }
    }

    private void refreshStatistics() {
        totalCount = 0;
        totalCost = BigDecimal.ZERO;
        for (OrderItem orderItem : getCars()) {
            totalCount += orderItem.getDays();
            totalCost = totalCost.add(BigDecimal.valueOf(orderItem.getCar().getCost())
                    .multiply(BigDecimal.valueOf(orderItem.getDays())));
        }
    }

    private void validateSize(int idCar) {
        if (cars.size() > Constants.MAX_CARS_FOR_ONE_USER && !cars.containsKey(idCar)) {
            throw new ValidationException("Limit for Car reached: size=" + cars.size());
        }
    }

    public int getTotalCount() {
        return totalCount;
    }

    public Collection<OrderItem> getCars() {
        return cars.values();
    }

    public int getSize() {
        return cars.values().size();
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }
}
