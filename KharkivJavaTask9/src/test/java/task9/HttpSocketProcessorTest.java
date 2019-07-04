package task9;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.TransportService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import task9.server.http.GetCountHttp;
import task9.server.http.GetNameHttp;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HttpSocketProcessorTest {

    @Mock
    TransportService transportService;

    @InjectMocks
    GetNameHttp getNameHttp;

    @InjectMocks
    GetCountHttp getCountHttp;

    private Transport transport = new Transport();


    @Before
    public void setUp() {
        transport.setPrice(500);
        transport.setProducer("test");
    }

    @Test
    public void shouldReturnZeroWhenCartIsEmpty() {
        when(transportService.getCountOfTransport()).thenReturn(0);
        Assert.assertEquals(getCountHttp.doCommand(""), "{\"count\":0}");
    }

    @Test
    public void shouldReturnTestNameAndCostOfProductWhenBeerIsExist() {
        when(transportService.getTransportByID(anyInt())).thenReturn(transport);
        Assert.assertEquals(getNameHttp.doCommand("2"), "{\"Producer\":\"test\",\"Price\":500}");
    }
}
