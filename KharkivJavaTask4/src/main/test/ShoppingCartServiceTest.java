import com.epam.poliak.dao.AllTransportDao;
import com.epam.poliak.dao.ShoppingCartDao;
import com.epam.poliak.entity.Car;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.ShoppingCartService;
import com.epam.poliak.service.impl.ShoppingCartServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartServiceTest {

    @Mock
    AllTransportDao allTransportDao;
    @Mock
    ShoppingCartDao shoppingCartDao;

    @Mock
    Map<Transport, Integer> map;

    @Mock
    Map<Transport, Integer> linkedMap;

    @InjectMocks
    ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();

    @Test
    public void addItemToShoppingCartTest() {
        List<Transport> list = new ArrayList<>();
        Car car = new Car(4, 7000, "Nissan", 140, 2013);
        list.add(car);
        when(allTransportDao.getAllItemList()).thenReturn(list);
        shoppingCartService.addItemToShoppingCart(4, 2);
        verify(map, times(1)).put(eq(car), eq(2));
    }

    @Test
    public void bueAllTest() {

    }
}
