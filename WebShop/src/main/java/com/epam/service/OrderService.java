package com.epam.service;

import com.epam.entity.User;
import com.epam.model.ShoppingCart;

public interface OrderService {

    int makeOrder(ShoppingCart shoppingCart, User currentAccount);

}
