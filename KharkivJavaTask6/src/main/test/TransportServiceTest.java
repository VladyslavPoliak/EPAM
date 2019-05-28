import com.epam.poliak.dao.DAOTransport;
import com.epam.poliak.entity.Car;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.TransportService;
import com.epam.poliak.service.impl.TransportServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TransportServiceTest {

    @Mock
    DAOTransport daoTransport;

    @InjectMocks
    TransportService transportService = new TransportServiceImpl(daoTransport);

    private ArrayList<Transport> testTransportList;
    private Car car;
    private Car car2;
    private Car car3;

    @Before
    public void before() {
        testTransportList = new ArrayList<>();
        car = new Car(4, 7000, "Nissan", 140, 2013);
        car2 = new Car(5, 2000, "Nissan", 100, 2003);
        car3 = new Car(7, 1000, "Nissan", 100, 2003);

        testTransportList.add(car);
        testTransportList.add(car2);
        testTransportList.add(car3);
    }

    @Test
    public void getAllTransportTest() {
        when(daoTransport.getAllTransport()).thenReturn(testTransportList);
        ArrayList<Transport> transportList = transportService.getAllTransport();
        verify(daoTransport, times(1)).getAllTransport();
        assertEquals(car, transportList.get(0));
        assertEquals(car2, transportList.get(1));
        assertEquals(car3, transportList.get(2));
    }

    @Test
    public void getTransportByIDTest() {
        when(daoTransport.getTransportByID(0)).thenReturn(car3);
        Transport testCar = transportService.getTransportByID(0);
        verify(daoTransport, times(1)).getTransportByID(0);
        assertEquals(car3, testCar);
    }

}
