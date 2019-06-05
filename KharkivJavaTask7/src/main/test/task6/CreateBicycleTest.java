package task6;

import com.epam.poliak.creator.impl.BicycleCreator;
import com.epam.poliak.entity.Bicycles;
import com.epam.poliak.input.InputHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreateBicycleTest {

    @Mock
    InputHelper inputHelper;

    @InjectMocks
    BicycleCreator bicycleCreator;

    @Test
    public void testInput() {
        when(inputHelper.getInteger()).thenReturn(100).thenReturn(150).thenReturn(200);
        when(inputHelper.getString()).thenReturn("test");
        Bicycles bicycles = bicycleCreator.create(inputHelper);
        assertEquals(100, bicycles.getPrice());
        assertEquals(150, bicycles.getWheelSize());
        assertEquals(200, bicycles.getNumberAbsorber());
        assertEquals("test", bicycles.getProducer());
    }
}
