package com.epam.poliak.service;

public interface ShoppingCartService {

    void addItemToShoppingCart(int itemId, int days);

    long buyAll();

    void showCart();

    void show5LastInCart();
}
