package com.epam.service.impl;

import com.epam.entity.User;
import com.epam.model.ShoppingCart;
import com.epam.repository.OrderRepository;
import com.epam.service.OrderService;
import org.apache.log4j.Logger;

public class OrderServiceImpl implements OrderService {

    private static Logger LOGGER = Logger.getLogger(OrderServiceImpl.class);

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public int makeOrder(ShoppingCart shoppingCart, User currentAccount) {
        return orderRepository.makeOrder(shoppingCart, currentAccount);
    }
}
