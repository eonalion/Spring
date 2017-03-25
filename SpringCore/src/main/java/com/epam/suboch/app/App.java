package com.epam.suboch.app;

import com.epam.suboch.client.Client;
import com.epam.suboch.event.Event;
import com.epam.suboch.event.EventType;
import com.epam.suboch.logger.IEventLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.Map;

/**
 *
 */
public class App {
    @Autowired
    private Client client;
    @Autowired
    @Qualifier("cacheFileEventLogger")
    private IEventLogger defaultLogger;
    @Resource(name = "loggerMap")
    private Map<EventType, IEventLogger> loggerMap;

    private void logEvent(EventType eventType, Event event) {
        IEventLogger eventLogger = loggerMap.get(eventType);
        if (eventLogger == null) {
            eventLogger = defaultLogger; // qualified field
        }
        event.setMessage(eventType.toString());
        eventLogger.logEvent(event);
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) applicationContext.getBean("app");

        Event event = (Event) applicationContext.getBean("event");
        Event event2 = (Event) applicationContext.getBean("event");
        app.logEvent(EventType.INFO, event);
        app.logEvent(EventType.ERROR, event2);

        System.out.println(app.client); // autowired
    }

}
