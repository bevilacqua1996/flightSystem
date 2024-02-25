package org.bevilacqua1996.flightsystem.domain.vo;

public enum FlightStatus {

    SCHEDULED("scheduled"),
    ACTIVE("active"),
    LANDED("landed"),
    CANCELLED("cancelled"),
    INCIDENT("incident"),
    DIVERTED("diverted");

    private final String flightStatus;

    public String getFlightStatus() {
        return flightStatus;
    }

    FlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }
}
