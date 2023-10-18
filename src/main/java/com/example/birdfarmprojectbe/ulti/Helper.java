package com.example.birdfarmprojectbe.ulti;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Helper {
    public static Instant convertStringToInstant(String requestTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a, EEE MM/dd/yyyy", Locale.ENGLISH);
        sdf.setTimeZone(TimeZone.getTimeZone("America/Toronto"));
        Date date = sdf.parse(requestTime);
        Instant reqInstant = date.toInstant();
        return reqInstant;
    }
}
