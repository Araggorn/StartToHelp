package pl.coderslab.charity.converter;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeConverter {
    public static String timeNowShort(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
        LocalDateTime now = LocalDateTime.now();
        String dateTimeString = now.format(formatter);
        return dateTimeString;
    }

    public static String timeNowLong(){
        LocalDateTime now = LocalDateTime.now();
        String dateTimeString = now.toString(); //.replace("T"," ");
        return dateTimeString;
    }
}
