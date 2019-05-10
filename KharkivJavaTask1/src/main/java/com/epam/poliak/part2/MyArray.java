package com.epam.poliak.part2;

import java.util.*;
import java.util.function.Predicate;

public class MyArray implements List {
    private static final int INIT_SIZE = 5;
    private Object[] values;
    private int size;

    public MyArray() {
        this.values = new Object[INIT_SIZE];
    }

    public MyArray(int size) {
        this.values = new Object[size];
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
        int beforeSize = size;
        if (size + 1 == values.length) {
            increaseListSize();
        }
        values[size++] = o;
        return size != beforeSize;
    }

    @Override
    public void add(int index, Object element) {
        checkIndex(index);
        if (size + 1 == values.length) {
            increaseListSize();
        }
        Object[] temp = Arrays.copyOfRange(values, index, size);
        values[index] = element;
        System.arraycopy(temp, 0, values, index + 1, temp.length);
        size++;
    }

    private void increaseListSize() {
        values = Arrays.copyOf(values, (values.length * 3) / 2 + 1);
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index != -1) {
            remove(index);
            return true;
        } else {
            return false;
        }
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
        for (int i = 0; i < size(); ) {
            if (!c.contains(values[i])) {
                remove(values[i]);
            } else i++;
        }
        return true;
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
        values = new Object[0];
        size = 0;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        if (index < size) {
            return values[index];
        } else {
            return new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public Object set(int index, Object element) {
        checkIndex(index);
        if (index < size) {
            values[index] = element;
            return true;
        }
        return false;
    }

    private void checkIndex(int index) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public Object remove(int index) {
        checkIndex(index);
        Object removeElement = values[index];
        if (size() - index >= 0) {
            System.arraycopy(values, index + 1, values, index, size() - index);
        }
        size--;
        return removeElement;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == o) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int result = -1;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == o) {
                result = i;
            }
        }
        return result;
    }

    @Override
    public Object[] toArray(Object[] a) {
        if (size > a.length) {
            return Arrays.copyOf(this.values, size);
        }
        System.arraycopy(values, 0, a, 0, size);
        return a;
    }


    @Override
    public Iterator iterator() {
        return new DefaultIterator();
    }

    public Iterator myIterator(Predicate<Object> predicate) {
        return new MyIterator(predicate);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(values, size);
    }


    private class MyIterator implements Iterator {
        int cursor;
        private Predicate<Object> predicate;
        Iterator iterator;

        public MyIterator(Predicate<Object> predicate) {
            iterator = MyArray.this.iterator();
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
            checkIndex(cursor);
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
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }
}
