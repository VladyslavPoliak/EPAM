package spring;

import java.io.IOException;
import java.util.List;

public class CombinedEventLogger implements EventLogger {

    private List<EventLogger> loggers;

    public CombinedEventLogger(List<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) throws IOException {
        for (int i = 0; i < loggers.size(); i++) {
            loggers.get(i).logEvent(event);
        }
    }
}
