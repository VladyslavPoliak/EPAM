package spring;

import java.text.DateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;

public class Event {

    private int id;

    private String msg;

    private Date date;

    private DateFormat dateFormat;

    public Event(Date date, DateFormat format) {
        setId();
        this.date = date;
        dateFormat = format;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setId() {
        this.id = new Random().nextInt(50);
    }

    public int getId() {
        return id;
    }

    public static boolean isDay() {
        LocalTime time = LocalTime.of(8, 0);
        LocalTime time2 = LocalTime.of(17, 0);
        return LocalTime.now().isAfter(time) && LocalTime.now().isBefore(time2);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + dateFormat.format(date) +
                '}';
    }
}
