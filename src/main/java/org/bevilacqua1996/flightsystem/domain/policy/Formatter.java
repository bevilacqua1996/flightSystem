package org.bevilacqua1996.flightsystem.domain.policy;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public interface Formatter {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.of("UTC"));

    LocalDate parseDate(String date);
}
