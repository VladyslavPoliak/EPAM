package task6;

import com.epam.poliak.creator.impl.CarCreator;
import com.epam.poliak.entity.Car;
import com.epam.poliak.input.InputHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreateCarTest {

    @Mock
    InputHelper inputHelper;

    @InjectMocks
    CarCreator carCreator;

    @Test
    public void testInput() {
        when(inputHelper.getInteger()).thenReturn(100).thenReturn(150).thenReturn(200);
        when(inputHelper.getString()).thenReturn("test");
        Car car = carCreator.create(inputHelper);
        assertEquals(100, car.getPrice());
        assertEquals(150, car.getYearOfRelease());
        assertEquals(200, car.getEnginePower());
        assertEquals("test", car.getProducer());
    }
}
