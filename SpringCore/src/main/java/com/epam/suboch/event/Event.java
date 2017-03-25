package com.epam.suboch.event;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

/**
 *
 */

public class Event {
    private int id;
    private String message;
    private LocalDateTime date;

    private static final int MAX_ID = 500;
    private static final int MIN_ID = 1;

    public Event(Date date) {
        Random random = new Random();
        this.id = random.nextInt(MAX_ID - MIN_ID + 1) - MIN_ID;
        this.date = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static boolean isDay() {
        LocalDateTime d1 = LocalDateTime.now().withHour(7);
        LocalDateTime d2 = LocalDateTime.now().withHour(22);
        return LocalDateTime.now().isAfter(d1) && LocalDateTime.now().isBefore(d2);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", message='" + message +
                ", date=" + date +
                '}';
    }
}
