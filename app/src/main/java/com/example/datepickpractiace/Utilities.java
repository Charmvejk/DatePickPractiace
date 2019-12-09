package com.example.datepickpractiace;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {
    public static String getDateTimeEs1(final Date dateTime) {
        DateFormat df = new SimpleDateFormat("ss");
        return df.format(dateTime);
    }
}
