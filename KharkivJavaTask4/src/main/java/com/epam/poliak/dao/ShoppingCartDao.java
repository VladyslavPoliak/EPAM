package com.epam.poliak.dao;

public interface ShoppingCartDao {

    void addItemToShoppingCart(int itemId, int days);

    long buyAll();

    void showCart();

    void showLastCars();


}
