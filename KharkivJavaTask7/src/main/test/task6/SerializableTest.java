package task6;

import com.epam.poliak.repository.Repository;
import com.epam.poliak.repository.RepositoryImpl;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.TransportService;
import com.epam.poliak.service.impl.TransportServiceImpl;
import com.epam.poliak.utils.DeserializableAllTransport;
import com.epam.poliak.utils.SerializableAllTransport;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.zip.GZIPOutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SerializableTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();
    private File testFile;
    private File testGzip;
    private SerializableAllTransport serializeService;
    private DeserializableAllTransport deserializableService;
    private ArrayList<Transport> transports;
    private Repository repository = new RepositoryImpl();
    private TransportService transportService = new TransportServiceImpl(repository);

    @Before
    public void init() throws IOException {
        testFile = folder.newFile("testSave.bin");
        testGzip = folder.newFile("testGzip.bin");
        serializeService = new SerializableAllTransport(transportService);
        deserializableService = new DeserializableAllTransport();
        transports = repository.getAllTransport();
    }

    @Test
    public void shouldSaveListToFile() {
        serializeService.serializableData(testFile.getName());
        assertTrue(testFile.exists());
    }

    @Test
    public void shouldReturnDeSerializedList() {
        serializeService.serializableData(testFile.getName());
        ArrayList<Transport> load = deserializableService.deserializationData(testFile.getName());
        assertEquals(transports, load);
    }

    @Test
    public void shouldReturnEmptyList_whenFileNotExists() {
        ArrayList<Transport> load = deserializableService.deserializationData("testFile.bin");
        assertTrue(load.isEmpty());
    }

    @Test
    public void archivedFileShouldBeSmallerThenNonArchived() throws Exception {
        File file = new File("serialisation.txt");
        serializeService.serializableData(file.getName());
        try (FileOutputStream fos = new FileOutputStream(testGzip)) {
            GZIPOutputStream gz = new GZIPOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(gz);
            oos.writeObject(transports);
            oos.flush();
            oos.close();
            serializeService.serializableData(testFile.getName());
            System.out.println(file.length());
            System.out.println(testGzip.length());
        }
        assertTrue(file.length() > testGzip.length());
    }
}
