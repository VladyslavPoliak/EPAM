import com.epam.poliak.part1.CopyOnWriteList;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class CopyOnWriteListTest {

    private CopyOnWriteList copyOnWriteList = new CopyOnWriteList();

    @Test
    public void addTest() {
        fillContainer();
        assertFalse(copyOnWriteList.isEmpty());
    }

    @Test
    public void addByIndexTest() {
        CopyOnWriteList copyOnWriteList = new CopyOnWriteList();
        copyOnWriteList.add(0, "he");
        copyOnWriteList.add(0, "hge");
        copyOnWriteList.add(1, "hello");
        assertEquals("hello", copyOnWriteList.get(1));
        assertFalse(copyOnWriteList.isEmpty());
    }

    @Test
    public void addAllTest() {
        CopyOnWriteList copyOnWriteList = new CopyOnWriteList();
        assertTrue(copyOnWriteList.addAll(Arrays.asList("test", "test2")));
        String[] tmp = new String[]{"test", "test2"};
        assertTrue(copyOnWriteList.containsAll(Arrays.asList(tmp)));
    }

    @Test
    public void addAllByIndexTest() {
        CopyOnWriteList copyOnWriteList = new CopyOnWriteList();
        copyOnWriteList.add("hello");
        assertTrue(copyOnWriteList.addAll(0, Arrays.asList("test", "test2")));
        assertEquals("test", copyOnWriteList.get(0));
        assertEquals("hello", copyOnWriteList.get(2));
    }

    @Test
    public void getTest() {
        assertEquals("hello", copyOnWriteList.get(0));
        assertEquals("hello2", copyOnWriteList.get(1));
    }

    @Test
    public void removeTest() {
        assertEquals("hello2", copyOnWriteList.remove(1));
        assertTrue(copyOnWriteList.remove("hello"));
    }

    @Test
    public void removeAllTest() {
        assertTrue(copyOnWriteList.removeAll(Arrays.asList("hello", "hello2")));
    }

    @Test
    public void retainAllTest() {
        assertTrue(copyOnWriteList.add("hello3"));
        copyOnWriteList.retainAll(Arrays.asList("hello", "hello2"));
        assertEquals(-1, copyOnWriteList.indexOf("hello3"));
    }

    @Test
    public void iteratorTest() {
        Iterator iterator = copyOnWriteList.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("hello", iterator.next());
        assertEquals("hello2", iterator.next());
    }

    @Test
    public void COWiteratorTest() {
        Iterator iterator = copyOnWriteList.iterator(copyOnWriteList.toArray());
        assertTrue(iterator.hasNext());
        assertTrue(copyOnWriteList.add("hello"));
        assertEquals("hello", iterator.next());
        assertEquals("hello2", iterator.next());
    }

    @Test
    public void containsTest() {
        assertTrue(copyOnWriteList.contains("hello"));
    }

    @Test
    public void lastIndexOfTest() {
        copyOnWriteList.add("hello");
        assertEquals(2,copyOnWriteList.lastIndexOf("hello"));
    }

    @Test
    public void clearTest() {
        assertTrue(copyOnWriteList.add("hello"));
        copyOnWriteList.clear();
        assertEquals(0, copyOnWriteList.size());
    }

    @Test
    public void iteratorPredicateTest(){
        Predicate<Object> predicate = (s) -> s.equals("hello2") ;
        Iterator iterator=copyOnWriteList.myIterator(predicate);
        assertEquals("hello", iterator.next());
        assertTrue(iterator.hasNext());
    }

    @Test
    public void toArrayTest() {
        assertArrayEquals(new Object[]{"hello", "hello2",},copyOnWriteList.toArray());
    }

    @Before
    public void fillContainer() {
        copyOnWriteList.add("hello");
        copyOnWriteList.add("hello2");
    }
}
