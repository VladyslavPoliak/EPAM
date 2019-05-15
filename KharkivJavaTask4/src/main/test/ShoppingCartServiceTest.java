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

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartServiceTest {

    @Mock
    DAOShoppingCart dAOShoppingCart;


    @InjectMocks
    ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl(dAOShoppingCart);

    @Test
    public void addItemToShoppingCartTest() {
        List<Transport> list = new ArrayList<>();
        Car car = new Car(4, 7000, "Nissan", 140, 2013);
        list.add(car);
        shoppingCartService.addItemToShoppingCart(car, 2);

    }

    @Test
    public void bueAllTest() {

    }
}
