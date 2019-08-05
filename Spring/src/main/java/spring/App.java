package spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Map;

public class App {

    private Client client;
    private EventLogger logger;
    private Map<EventType, EventLogger> loggerMap;
    private Event event;
    private EventLogger defaultLogger;

    public App(Client client, EventLogger logger, Map<EventType, EventLogger> loggerMap, Event event) {
        this.client = client;
        this.logger = logger;
        this.loggerMap = loggerMap;
        this.event = event;
    }


    private void logEvent(EventType type, String msg) throws IOException {
        logger = loggerMap.get(type);
        if (logger == null) {
            logger = defaultLogger;
        }
        event.setMsg(msg.replaceAll(client.getId(), client.getName()) + " " + client.getGreeting());
        logger.logEvent(event);
    }

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");
        app.defaultLogger = context.getBean("cache", EventLogger.class);
        app.logEvent(EventType.ERROR, "ERROR 1");
        app.logEvent(EventType.INFO, "INFO 1");

        context.close();
    }

}
