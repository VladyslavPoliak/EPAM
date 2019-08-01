package spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class App {

    private Client client;

    private EventLogger logger;

    private Event event;

    public App(Client client, EventLogger logger, Event event) {
        this.client = client;
        this.logger = logger;
        this.event = event;
    }


    public void logEvent(String msg) throws IOException {
        String message = msg.replaceAll(client.getId(), client.getName());
        event.setMsg(message);
        logger.logEvent(event);
    }

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");
        app.logEvent("some text 1");

        context.close();
    }

}
