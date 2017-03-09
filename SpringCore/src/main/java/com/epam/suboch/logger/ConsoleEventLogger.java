package com.epam.suboch.logger;


import com.epam.suboch.event.Event;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class ConsoleEventLogger implements IEventLogger {
    public static final Logger LOG = LogManager.getLogger();

    public void logEvent(Event event) {
        LOG.info(event.toString());
    }
}
