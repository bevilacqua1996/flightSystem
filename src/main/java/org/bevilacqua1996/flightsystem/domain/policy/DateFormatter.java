package org.bevilacqua1996.flightsystem.domain.policy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DateFormatter implements Formatter {

    @Override
    public LocalDate parseDate(String date) {
        return LocalDateTime.parse(date, formatter).atOffset(ZoneOffset.UTC).toLocalDate();
    }
}
