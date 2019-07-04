package task7;

import com.epam.poliak.command.impl.AddNewTransportReflection;
import com.epam.poliak.creator.ReflectionCreator;
import com.epam.poliak.input.InputHelper;
import com.epam.poliak.io.impl.ReaderImpl;
import com.epam.poliak.io.impl.WriterImpl;
import com.epam.poliak.service.TransportService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AddNewTransportByReflection {

    @Mock
    TransportService transportService;
    @Mock
    InputHelper inputHelper;
    private ResourceBundle bundle = ResourceBundle.getBundle("content", Locale.getDefault());

    @After
    public void after() {
        System.setIn(System.in);
    }

    @Test
    public void reflectionTest() throws UnsupportedEncodingException {
        System.setIn(new ByteArrayInputStream("1".getBytes("Cp1251")));
        when(inputHelper.getInteger()).thenReturn(100).thenReturn(150).thenReturn(200);
        when(inputHelper.getString()).thenReturn("test");
        AddNewTransportReflection addNewTransportReflection = new AddNewTransportReflection(new ReaderImpl(), new WriterImpl(), transportService, inputHelper, bundle);
        addNewTransportReflection.doCommand();
        verify(transportService, times(1))
                .addNewTransport(new ReflectionCreator(new WriterImpl()).create("1", bundle, inputHelper));
    }

}
