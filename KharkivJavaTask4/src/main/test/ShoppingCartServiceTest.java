import com.epam.poliak.dao.DAOShoppingCart;
import com.epam.poliak.entity.Car;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.ShoppingCartService;
import com.epam.poliak.service.impl.ShoppingCartServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartServiceTest {

    @Mock
    DAOShoppingCart dAOShoppingCart;
    @Mock
    Map<Transport, Integer> shoppingCart;
    @Mock
    Map<Transport, Integer> shoppingCartStorage;

    @InjectMocks
    ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl(dAOShoppingCart);

    @Test
    public void addItemToShoppingCartTest() {
        Car car = new Car(4, 7000, "Nissan", 140, 2013);
        Map<Transport, Integer> map = new HashMap<>();
        when(dAOShoppingCart.getShoppingCart()).thenReturn(map);
        shoppingCartService.addItemToShoppingCart(car, 2);
//       verify(shoppingCart,times(1)).put(eq(car),2);
//       verify(shoppingCartStorage,times(1)).put(eq(car),2);

    }

    @Test
    public void bueAllTest() {

    }
}
