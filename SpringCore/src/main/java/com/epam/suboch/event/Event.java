package com.epam.suboch.event;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 */
public class Event {
    private int id;
    private String message;
    private Date date;
    private DateFormat dateFormat;
    private static final int MAX_ID = 500;
    private static final int MIN_ID = 1;

    public Event(Date date, DateFormat dateFormat) {
        Random random = new Random();
        this.id = random.nextInt(MAX_ID - MIN_ID + 1) - MIN_ID;
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", message='" + message +
                ", date=" + dateFormat.format(date) +
                '}';
    }
}
