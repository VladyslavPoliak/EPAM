package com.epam.repository;

import com.epam.entity.User;
import com.epam.model.ShoppingCart;

public interface OrderRepository {

    int makeOrder(ShoppingCart shoppingCart, User currentAccount);


}
