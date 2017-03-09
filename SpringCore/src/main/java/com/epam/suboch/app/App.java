package com.epam.suboch.app;

import com.epam.suboch.client.Client;
import com.epam.suboch.event.Event;
import com.epam.suboch.event.EventType;
import com.epam.suboch.logger.IEventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 *
 */
public class App {
    private Client client;
    private IEventLogger defaultLogger;
    private Map<EventType, IEventLogger> loggerMap;


    public App(Client client, Map<EventType, IEventLogger> loggerMap, IEventLogger defaultLogger) {
        this.client = client;
        this.loggerMap = loggerMap;
        this.defaultLogger = defaultLogger;
    }

    public void logEvent(EventType eventType, Event event) {
        IEventLogger eventLogger = loggerMap.get(eventType);
        if (eventLogger == null) {
            eventLogger = defaultLogger;
        }
        event.setMessage(eventType.toString());
        eventLogger.logEvent(event);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) applicationContext.getBean("app");

        Event event = (Event) applicationContext.getBean("event");
        Event event2 = (Event) applicationContext.getBean("event");
        app.logEvent(EventType.INFO, event);
        app.logEvent(EventType.ERROR, event2);
    }

}
