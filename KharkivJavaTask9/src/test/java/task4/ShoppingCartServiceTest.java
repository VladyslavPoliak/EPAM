package task4;

import com.epam.poliak.entity.Car;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.model.ShoppingCart;
import com.epam.poliak.service.ShoppingCartService;
import com.epam.poliak.service.impl.ShoppingCartServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartServiceTest {

    @Mock
    ShoppingCart shoppingCart;
    @InjectMocks
    ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl(shoppingCart);
    private Map<Transport, Integer> map;

    @Before
    public void before() {
        Car car = new Car(4, 7000, "Nissan", 140, 2013);
        Car car2 = new Car(5, 2000, "Nissan", 100, 2003);
        map = new HashMap<>();
        map.put(car, 4);
        map.put(car2, 6);
    }

    @Test
    public void addItemToShoppingCartTest() {
        Car car = new Car(4, 7000, "Nissan", 140, 2013);
        when(shoppingCart.getDays(car)).thenReturn(0);
        shoppingCartService.addItemToShoppingCart(car, 4);
        verify(shoppingCart, times(1)).getDays(eq(car));
        verify(shoppingCart, times(1)).addItemToShoppingCart(eq(car), eq(4));
    }

    @Test
    public void buyAll() {
        when(shoppingCart.getShoppingCart()).thenReturn(map);
        shoppingCartService.buyAll();
        verify(shoppingCart, times(1)).clearShoppingCart();
        assertEquals(40000, shoppingCartService.buyAll());
    }
}
