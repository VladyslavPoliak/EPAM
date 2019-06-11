package com.epam.poliak.service;

import com.epam.poliak.entity.Transport;

import java.util.Map;

public interface ShoppingCartStorageService {

     Map<Transport, Integer> getShoppingCartStorage();

    void addItemToShoppingCartStorage(Transport transport, int days);

}
