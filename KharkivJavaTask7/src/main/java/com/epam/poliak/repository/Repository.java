package com.epam.poliak.repository;

import java.util.List;

public interface Repository<T> {

    List<T> getAll();

    T get(int id);

    void addNew(int id, T transport);
}
