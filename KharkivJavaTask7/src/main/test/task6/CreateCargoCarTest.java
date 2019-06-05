package task6;

import com.epam.poliak.creator.impl.CargoCarCreator;
import com.epam.poliak.entity.CargoCar;
import com.epam.poliak.input.InputHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreateCargoCarTest {

    @Mock
    InputHelper inputHelper;

    @InjectMocks
    CargoCarCreator cargoCarCreator;

    @Test
    public void testInput() {
        when(inputHelper.getInteger()).thenReturn(100).thenReturn(150).thenReturn(200)
                .thenReturn(250).thenReturn(300);
        when(inputHelper.getString()).thenReturn("test");
        CargoCar cargoCar = cargoCarCreator.create(inputHelper);
        assertEquals(100, cargoCar.getPrice());
        assertEquals(150, cargoCar.getYearOfRelease());
        assertEquals(200, cargoCar.getEnginePower());
        assertEquals(250, cargoCar.getNumberOfTrailers());
        assertEquals(300, cargoCar.getMaxTransportWeight());
        assertEquals("test", cargoCar.getProducer());
    }

}
