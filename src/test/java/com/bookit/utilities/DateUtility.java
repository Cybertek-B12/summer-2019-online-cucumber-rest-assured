package com.bookit.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtility {

    public static String getTodaysDate(String format){
        return LocalDate.now().format(DateTimeFormatter.ofPattern(format));
    }
}
