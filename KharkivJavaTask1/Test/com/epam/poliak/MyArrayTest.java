package com.epam.poliak;

import com.epam.poliak.part2.MyArray;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Predicate;

import static org.junit.Assert.*;


public class MyArrayTest {
    @Test
    public void addTest() {
        MyArray myArray = new MyArray();
        assertTrue(myArray.add("hello"));
        assertTrue(myArray.add("hello2"));
        assertFalse(myArray.isEmpty());

    }

    @Test
    public void addByIndexTest() {
        MyArray myArray = new MyArray(5);
        myArray.add(0, "he");
        myArray.add(0, "hge");
        myArray.add(1, "hello");
        assertEquals("hello", myArray.get(1));
        assertFalse(myArray.isEmpty());
    }

    @Test
    public void addAllTest() {
        MyArray myArray = new MyArray();
        assertTrue(myArray.addAll(Arrays.asList("test", "test2")));
        String[] tmp = new String[]{"test", "test2"};
        assertTrue(myArray.containsAll(Arrays.asList(tmp)));
    }

    @Test
    public void addAllByIndexTest() {
        MyArray myArray = new MyArray();
        myArray.add("hello");
        assertTrue(myArray.addAll(0, Arrays.asList("test", "test2")));
        assertEquals("test", myArray.get(0));
        assertEquals("hello", myArray.get(2));
    }

    @Test
    public void getTest() {
        MyArray myArray = new MyArray();
        assertTrue(myArray.add("hello"));
        assertTrue(myArray.add("hello2"));
        assertEquals("hello", myArray.get(0));
        assertEquals("hello2", myArray.get(1));
    }

    @Test
    public void removeTest() {
        MyArray myArray = new MyArray();
        assertTrue(myArray.add("hello"));
        assertTrue(myArray.add("hello2"));
        assertEquals("hello2", myArray.remove(1));
        assertTrue(myArray.remove("hello"));
        assertTrue(myArray.isEmpty());
    }

    @Test
    public void removeAllTest() {
        MyArray myArray = new MyArray();
        assertTrue(myArray.add("hello"));
        assertTrue(myArray.add("hello2"));
        assertTrue(myArray.add("hello3"));
        myArray.removeAll(Arrays.asList("hello", "hello2"));
        assertEquals(-1, myArray.indexOf("hello"));
    }

    @Test
    public void retainAllTest() {
        MyArray myArray = new MyArray();
        assertTrue(myArray.add("hello"));
        assertTrue(myArray.add("hello2"));
        assertTrue(myArray.add("hello3"));
        myArray.retainAll(Arrays.asList("hello", "hello2"));
        assertEquals(-1, myArray.indexOf("hello3"));
    }

    @Test
    public void iteratorTest(){
        MyArray myArray = new MyArray();
        assertTrue(myArray.add("hello"));
        assertTrue(myArray.add("hello2"));
        assertTrue(myArray.add("hello3"));
        assertTrue(myArray.add("hello4"));
        Predicate<Object> predicate = (s) -> s.equals("hello2") ;
        Iterator iterator=myArray.myIterator(predicate);
        assertEquals("hello", iterator.next());
    }

    @Test
    public void containsTest() {
        MyArray myArray = new MyArray();
        assertTrue(myArray.add("hello"));
        assertTrue(myArray.add("hello2"));
        assertTrue(myArray.contains("hello"));
    }

    @Test
    public void clearTest() {
        MyArray myArray = new MyArray();
        assertTrue(myArray.add("hello"));
        myArray.clear();
        assertEquals(0, myArray.size());
    }
}
