package com.epam.poliak.part1;

import java.util.ArrayList;
import java.util.Collection;

public class NoDuplicateList<T> extends ArrayList<T> {


    @Override
    public T set(int index, T element) {
        checkIndex(index);
        if (indexOf(element) != index) {
            throw new IllegalArgumentException();
        }
        isContains(element);
        return super.set(index, element);
    }

    @Override
    public boolean add(T element) {
        isContains(element);
        return super.add(element);
    }

    @Override
    public void add(int index, T element) {
        checkIndex(index);
        isContains(element);
        super.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        checkCollection(collection);
        return super.addAll(collection);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> collection) {
        checkIndex(index);
        checkCollection(collection);
        return super.addAll(index, collection);
    }

    private void checkCollection(Collection<? extends T> collection) {
        Object[] array = collection.toArray();
        for (Object o : array) {
            isContains(((T) o));
        }
    }

    private void checkIndex(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void isContains(T element) {
        if (contains(element)) {
            throw new IllegalArgumentException();
        }
    }
}
