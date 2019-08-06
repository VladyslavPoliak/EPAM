package spring;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {

    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
        cache = new ArrayList<>();
    }

    @Override
    public void logEvent(Event event) throws IOException {
        cache.add(event);
        if (cache.size() == cacheSize) {
            writeEventsFromCache();
        }
    }

    public void destroy() throws IOException {
        if (!cache.isEmpty()) {
            writeEventsFromCache();
        }
    }

    private void writeEventsFromCache() throws IOException {
        for (Event event : cache) {
            super.logEvent(event);
        }
        cache.clear();
    }
}
