import com.epam.poliak.dao.DAOShoppingCart;
import com.epam.poliak.entity.Car;
import com.epam.poliak.service.ShoppingCartService;
import com.epam.poliak.service.impl.ShoppingCartServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartServiceTest {

    @Mock
    DAOShoppingCart dAOShoppingCart;

    @InjectMocks
    ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl(dAOShoppingCart);

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

}
