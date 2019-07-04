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
import task9.server.tcp.GetCountTcp;
import task9.server.tcp.GetNameTcp;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TcpSocketProcessorTest {

    @Mock
    TransportService transportService;

    @InjectMocks
    GetNameTcp getNameTcp;

    @InjectMocks
    GetCountTcp getCountTcp;

    private Transport transport = new Transport();


    @Before
    public void setUp() {
        transport.setPrice(500);
        transport.setProducer("test");
    }

    @Test
    public void shouldReturnZeroWhenCartIsEmpty() {
        when(transportService.getCountOfTransport()).thenReturn(0);
        Assert.assertEquals(getCountTcp.doCommand(""), "0");
    }

    @Test
    public void shouldReturnTestNameAndCostOfProductWhenBeerIsExist() {
        when(transportService.getTransportByID(anyInt())).thenReturn(transport);
        Assert.assertEquals(getNameTcp.doCommand("2"), "test|500");
    }
}