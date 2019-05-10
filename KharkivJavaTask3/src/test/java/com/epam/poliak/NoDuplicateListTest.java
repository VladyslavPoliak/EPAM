package com.epam.poliak;

import com.epam.poliak.part1.NoDuplicateList;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NoDuplicateListTest {

    private List<String> arrayList = new ArrayList<>();
    private List<String> duplicateArrayList = new ArrayList<>();
    private NoDuplicateList<String> noDuplicateList = new NoDuplicateList<>();

    @Before
    public void fillList() {
        arrayList.add("hello");
        arrayList.add("hello2");
        noDuplicateList.add("test");
        noDuplicateList.add("test2");
        duplicateArrayList.add("test");
        duplicateArrayList.add("test2");
    }

    @Test
    public void testAddMethod() {
        assertTrue(noDuplicateList.add("test3"));
        assertTrue(noDuplicateList.add("test4"));
    }

    @Test
    public void testAddByIndexMethod() {
        noDuplicateList.add(1, "test3");
        noDuplicateList.add(1, "test4");
        assertEquals("test4", noDuplicateList.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void tryAddDuplicate() {
        assertTrue(noDuplicateList.add("test"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void tryAddToIncorrectIndex() {
        noDuplicateList.add(10, "test");
    }

    @Test
    public void testAddAllMethod() {
        assertTrue(noDuplicateList.addAll(arrayList));
    }

    @Test
    public void testAddAllByIndex() {
        assertTrue(noDuplicateList.addAll(0, arrayList));
        String[] arr = new String[]{"hello", "hello2", "test", "test2"};
        assertArrayEquals(arr, noDuplicateList.toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void tryAddDuplicateCollection() {
        assertTrue(noDuplicateList.addAll(duplicateArrayList));
    }

    @Test
    public void testSetMethod() {
        assertEquals("test", noDuplicateList.set(0, "test set"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void trySetDuplicate() {
        assertEquals("test", noDuplicateList.set(0, "test"));

    }

}
