package fr.util.date;

import java.time.LocalDate;

public class DateUtil {

    public static LocalDate parseDate(String date) {
        return  LocalDate.parse(date);
    }

    public static int calculAge(LocalDate today, LocalDate birth){
       return today.getYear()- birth.getYear();
    }
}
