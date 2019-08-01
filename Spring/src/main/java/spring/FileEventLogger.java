package spring;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileEventLogger implements EventLogger {

    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void init() throws IOException {
        this.file = new File(fileName);
        if (!file.canWrite()) {
            throw new IOException();
        }
    }

    @Override
    public void logEvent(Event event) throws IOException {
        FileUtils.writeStringToFile(file, event.toString(), Charset.defaultCharset());
    }
}
