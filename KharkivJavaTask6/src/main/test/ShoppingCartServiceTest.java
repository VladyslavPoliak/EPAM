import com.epam.poliak.dao.DAOShoppingCart;
import com.epam.poliak.entity.Car;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.ShoppingCartService;
import com.epam.poliak.service.impl.ShoppingCartServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartServiceTest {

    @Mock
    DAOShoppingCart dAOShoppingCart;
    @InjectMocks
    ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl(dAOShoppingCart);
    private Map<Transport, Integer> shoppingCart;
    private Map<Transport, Integer> shoppingCartStorage;
    private Car car;
    private Car car2;
    private Car car3;

    @Before
    public void before() {
        car = new Car(4, 7000, "Nissan", 140, 2013);
        car2 = new Car(5, 2000, "Nissan", 100, 2003);
        car3 = new Car(7, 1000, "Nissan", 100, 2003);
        shoppingCart = new HashMap<>();
        shoppingCartStorage = new LinkedHashMap<>();
        shoppingCart.put(car, 4);
        shoppingCart.put(car2, 6);
        shoppingCartStorage.put(car, 4);
        shoppingCartStorage.put(car2, 6);
    }

    @Test
    public void addItemToShoppingCartTest() {
        Car car = new Car(4, 7000, "Nissan", 140, 2013);
        when(dAOShoppingCart.getDays(car)).thenReturn(0);
        shoppingCartService.addItemToShoppingCart(car, 4);
        verify(dAOShoppingCart, times(1)).getDays(eq(car));
        verify(dAOShoppingCart, times(1)).addItemToShoppingCart(eq(car), eq(4));
    }

    @Test
    public void buyAllTest() {
        when(dAOShoppingCart.buyAll()).thenReturn(0L);
        shoppingCartService.buyAll();
        assertEquals(0L, dAOShoppingCart.buyAll());
    }

    @Test
    public void getShoppingCartTest() {
        when(shoppingCartService.getShoppingCart()).thenReturn(shoppingCart);
        Map<Transport, Integer> testMap = shoppingCartService.getShoppingCart();
        Assert.assertTrue(shoppingCart.containsKey(car) && testMap.containsKey(car));
        Assert.assertTrue(shoppingCart.containsKey(car2) && testMap.containsKey(car2));
        Assert.assertFalse(shoppingCart.containsKey(car3) && testMap.containsKey(car3));
    }

    @Test
    public void getShoppingCartStorageTest() {
        when(shoppingCartService.getShoppingCartStorage()).thenReturn(shoppingCartStorage);
        Map<Transport, Integer> testMap = shoppingCartService.getShoppingCartStorage();
        Assert.assertTrue(shoppingCartStorage.containsKey(car) && testMap.containsKey(car));
        Assert.assertTrue(shoppingCartStorage.containsKey(car2) && testMap.containsKey(car2));
        Assert.assertFalse(shoppingCartStorage.containsKey(car3) && testMap.containsKey(car3));
    }
}
