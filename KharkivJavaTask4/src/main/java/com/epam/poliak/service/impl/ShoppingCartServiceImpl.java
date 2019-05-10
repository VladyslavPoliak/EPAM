package com.epam.poliak.service.impl;

import com.epam.poliak.dao.ShoppingCartDao;
import com.epam.poliak.dao.impl.ShoppingCartDaoImpl;
import com.epam.poliak.service.ShoppingCartService;

public class ShoppingCartServiceImpl implements ShoppingCartService {

    private ShoppingCartDao shoppingCartDao = new ShoppingCartDaoImpl();

    @Override
    public void addItemToShoppingCart(int itemId, int days) {
        shoppingCartDao.addItemToShoppingCart(itemId, days);
    }

    @Override
    public long buyAll() {
        return shoppingCartDao.buyAll();
    }

    @Override
    public void showCart() {
        shoppingCartDao.showCart();
    }
}
