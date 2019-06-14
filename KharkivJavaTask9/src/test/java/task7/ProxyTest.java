package task7;

import org.junit.Test;
import task7_3.Transport;
import task7_4.TransportCreator;
import task7_5.MapHandler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ProxyTest {

    @Test(expected = UnsupportedOperationException.class)
    public void shouldThrowException() {
        Transport transport = new TransportCreator().create();
        transport.setEnginePower(1000);
    }

    @Test
    public void ProxyMapTest() {
        Transport transport = new MapHandler().create();
        transport.setEnginePower(1000);
        int expected = 1000;
        int actual = transport.getEnginePower();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnDefaultValuesIfNotSet() {
        Transport transport = new MapHandler().create();
        assertNull(transport.getProducer());
        assertEquals(0, transport.getPrice());
    }
}
