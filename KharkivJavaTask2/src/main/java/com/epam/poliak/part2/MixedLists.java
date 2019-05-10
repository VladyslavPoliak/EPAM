package com.epam.poliak.part2;

import java.util.*;

public class MixedLists<T> implements List<T> {

    private List<T> modifiableList;
    private List<T> readOnlyList;

    public MixedLists(List<T> readOnlyList, List<T> modifiableList) {
        this.modifiableList = modifiableList;
        this.readOnlyList = readOnlyList;
    }

    @Override
    public boolean add(T t) {
        return modifiableList.add(t);
    }

    @Override
    public boolean isEmpty() {
        return modifiableList.isEmpty() && readOnlyList.isEmpty();
    }

    @Override
    public int size() {
        return modifiableList.size() + readOnlyList.size();
    }

    @Override
    public boolean contains(Object o) {
        if (readOnlyList.contains(o)) {
            return true;
        } else {
            return modifiableList.contains(o);
        }
    }

    @Override
    public boolean remove(Object o) {
        if (readOnlyList.contains(o)) {
            throw new IllegalStateException();
        }
        return modifiableList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (readOnlyList.containsAll(c)) {
            return modifiableList.containsAll(c);
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return modifiableList.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        checkIndex(index);
        checkArrayByIndex(index);
        return modifiableList.addAll(index - readOnlyList.size(), c);
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        if (readOnlyList.removeAll(collection)) {
            throw new IllegalArgumentException();
        }
        return modifiableList.removeAll(collection);
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        if (!readOnlyList.retainAll(collection)) {
            throw new IllegalArgumentException();
        }
        return modifiableList.retainAll(collection);
    }

    @Override
    public void clear() {
        modifiableList.clear();
    }

    @Override
    public T set(int index, T element) {
        checkArrayByIndex(index);
        checkIndex(index);
        return modifiableList.set(index - readOnlyList.size(), element);
    }

    private void checkIndex(int index) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkArrayByIndex(int index) {
        if (index < readOnlyList.size()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void add(int index, T element) {
        checkIndex(index);
        checkArrayByIndex(index);
        modifiableList.add(index - readOnlyList.size(), element);
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        T res;
        if (index >= readOnlyList.size()) {
            res = modifiableList.get(index - readOnlyList.size());
        } else {
            res = readOnlyList.get(index);
        }
        return res;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        checkArrayByIndex(index);
        return modifiableList.remove(index - readOnlyList.size());
    }

    @Override
    public int indexOf(Object o) {
        List<T> tmp = readOnlyList;
        tmp.addAll(modifiableList);
        return tmp.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        List<T> tmp = readOnlyList;
        tmp.addAll(modifiableList);
        return tmp.lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new NullPointerException();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new NullPointerException();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Object[] array = toArray();
            private int position;

            @Override
            public boolean hasNext() {
                return position < array.length;
            }

            @Override
            public T next() {
                if (position >= size()) {
                    throw new NoSuchElementException();
                }
                int lastReturned = position;
                ++position;
                return (T) array[lastReturned];
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        System.arraycopy(readOnlyList.toArray(), 0, array, 0, readOnlyList.size());
        System.arraycopy(modifiableList.toArray(), 0, array, readOnlyList.size(), modifiableList.size());
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size()) {
            return (T1[]) Arrays.copyOf(toArray(), size());
        }
        System.arraycopy(toArray(), 0, a, 0, size());
        if (a.length > size()) {
            a[size()] = null;
        }
        return a;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new NullPointerException();
    }


}
