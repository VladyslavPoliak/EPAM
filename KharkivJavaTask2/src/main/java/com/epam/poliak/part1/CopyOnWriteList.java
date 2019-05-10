package com.epam.poliak.part1;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

public class CopyOnWriteList implements List {

    private final ReentrantLock lock = new ReentrantLock();
    private static int INIT_SIZE = 5;
    private Object[] values;
    private int size;

    public CopyOnWriteList() {
        this.values = new Object[INIT_SIZE];
    }

    public CopyOnWriteList(int size) {
        this.values = new Object[size];
    }

    public Object[] getValues() {
        return values;
    }

    public void setValues(Object[] values) {
        this.values = values;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object ob) {
        return indexOf(ob) >= 0;
    }

    @Override
    public boolean add(Object o) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] elements = getValues();
            elements = Arrays.copyOf(elements, elements.length + 1);
            elements[elements.length - 1] = o;
            setValues(elements);
            return true;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void add(int index, Object element) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] elements = getValues();
            checkIndex(index);
            elements = Arrays.copyOf(elements, elements.length + 1);
            System.arraycopy(elements, index, elements, index + 1, elements.length - index - 1);
            elements[index] = element;
            setValues(elements);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean remove(Object o) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] elements = getValues();
            for (int i = 0; i < elements.length; i++) {
                if (elements[i].equals(o)) {
                    elements = remove(elements, i);
                    setValues(elements);
                    return true;
                }
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    private Object[] remove(Object[] elements, int i) {
        System.arraycopy(elements, i + 1, elements, i, elements.length - i - 1);
        elements = Arrays.copyOf(elements, elements.length - 1);
        return elements;
    }

    @Override
    public boolean addAll(Collection c) {
        Object[] temp = c.toArray();
        for (Object value : temp) {
            add(value);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        checkIndex(index);
        Object[] temp = c.toArray();
        for (Object o : temp) {
            add(index++, o);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection c) {
        int index = 0;
        boolean result = false;
        if (this.containsAll(c)) {
            result = true;
        }

        while (index < size) {
            Object e = values[index];
            if (!(c.contains(e))) {
                remove(e);
            } else {
                index++;
            }
        }
        return result;
    }


    @Override
    public boolean removeAll(Collection c) {
        Object[] temp = c.toArray();
        for (Object o : temp) {
            if (contains(o)) {
                remove(indexOf(o));
            }
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        if (values.length == INIT_SIZE) {
            Arrays.fill(values, null);
        } else {
            values = new Object[INIT_SIZE];
        }
        size = 0;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        Object[] elements = getValues();
        if (index < size) {
            return elements[index];
        } else {
            return new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public Object set(int index, Object element) {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] elements = getValues();
            checkIndex(index);
            Object oldValue = elements[index];
            elements[index] = element;
            return oldValue;
        } finally {
            lock.unlock();
        }
    }

    private void checkIndex(int index) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public Object remove(int index) {
        checkIndex(index);
        Object[] elements = getValues();
        Object oldValue = elements[index];
        if (size() - index >= 0) {
            System.arraycopy(elements, index + 1, elements, index, size() - index);
        }
        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        Object[] elements = getValues();
        for (int i = 0; i < elements.length; i++) {
            if (values[i] == o) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Object[] elements = getValues();
        int result = -1;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == o) {
                result = i;
            }
        }
        return result;
    }

    @Override
    public Object[] toArray(Object[] a) {
        Object[] elements = getValues();
        if (elements.length > a.length) {
            return Arrays.copyOf(elements, size());
        }
        System.arraycopy(values, 0, a, 0, size);
        return a;

    }


    @Override
    public Iterator iterator() {
        return new CopyOnWriteList.DefaultIterator();
    }

    public Iterator myIterator(Predicate<Object> predicate) {
        return new CopyOnWriteList.MyIterator(predicate);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(values, size);
    }


    private class MyIterator implements Iterator {
        int cursor;
        private Predicate<Object> predicate;
        Iterator iterator;

        MyIterator(Predicate<Object> predicate) {
            iterator = CopyOnWriteList.this.iterator();
            this.predicate = predicate;
        }

        /**
         * Returns true if the iteration matches the given condition.
         */
        @Override
        public boolean hasNext() {
            for (int i = cursor; i < size; i++) {
                if (predicate.test(values[i])) {
                    cursor = i;
                    return true;
                }
            }
            return false;
        }

        /**
         * Returns the next element in the iteration.
         */
        @Override
        public Object next() {
            return values[cursor++];
        }

    }

    private class DefaultIterator implements Iterator {
        int cursor;
        int lastReturned = -1;

        @Override
        public boolean hasNext() {
            return cursor < size();
        }

        @Override
        public Object next() {
            if (cursor >= size()) {
                throw new NoSuchElementException();
            }
            lastReturned = cursor;
            ++cursor;
            return get(lastReturned);
        }
    }


    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    public Iterator iterator(Object[] array) {
        return new COWIterator(array);
    }

    private class COWIterator implements Iterator {
        private final Object[] snapshot;
        private int position;

        COWIterator(Object[] array) {
            snapshot = array;
        }

        @Override
        public boolean hasNext() {
            return position < snapshot.length;
        }

        @Override
        public Object next() {
            if (position >= size()) {
                throw new NoSuchElementException();
            }
            int lastReturned = position;
            ++position;
            return snapshot[lastReturned];
        }
    }
}
