package com.epam.poliak.service;

public interface ShoppingCart {

    void addItemToShoppingCart(int itemId, int days);

    long buyAll();

    void showCart();
}
