package org.bevilacqua1996.flightsystem.domain.policy;

import java.time.LocalDate;

public class DateFormatter implements Formatter {

    @Override
    public LocalDate parseDate(String date) {
        return LocalDate.parse(date, formatter);
    }
}
