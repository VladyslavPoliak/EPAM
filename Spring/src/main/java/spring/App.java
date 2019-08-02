package spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Map;

public class App {

    private Client client;
    private EventLogger logger;
    private Map<EventType,EventLogger> loggerMap;


    public App(Client client, EventLogger logger, Map<EventType,EventLogger> loggerMap ) {
        this.client = client;
        this.logger = logger;
        this.loggerMap=loggerMap;
    }


    private void logEvent(EventType type,String msg) throws IOException {
       EventLogger logger=loggerMap.get(type);
       if (logger==null){

       }
    }

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");


        context.close();
    }

}
