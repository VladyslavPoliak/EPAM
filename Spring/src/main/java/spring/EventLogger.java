package spring;

import java.io.IOException;

public interface EventLogger {

     void logEvent(Event event) throws IOException;

}
