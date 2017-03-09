package com.epam.suboch.logger;

import com.epam.suboch.event.Event;

import java.util.List;

/**
 *
 */
public class CombinedEventLogger implements IEventLogger {
    private List<IEventLogger> loggers;

    public CombinedEventLogger(List<IEventLogger> loggers) {
        this.loggers = loggers;
    }

    public void logEvent(Event event) {
        for(IEventLogger logger:loggers){
            logger.logEvent(event);
        }
    }
}
