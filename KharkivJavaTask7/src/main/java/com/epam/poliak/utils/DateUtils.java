package com.epam.poliak.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static Date getDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            return format.parse(date);
        } catch (ParseException e) {
            System.out.println("Incorrect data");
        }
        return new Date();
    }

    public static Date determineNearestDate(Date mainDate, Date date, Date date2) {
        long difference = date2.getTime() - mainDate.getTime();
        long difference2 = Math.abs(date.getTime() - mainDate.getTime());
        return difference > difference2 ? date : date2;
    }

}
