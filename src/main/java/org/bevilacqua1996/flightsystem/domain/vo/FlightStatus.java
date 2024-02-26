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

    public static FlightStatus ofStatus(String status) {
        for(FlightStatus flightStatus : FlightStatus.values()) {
            if(flightStatus.getFlightStatus().equals(status)) {
                return flightStatus;
            }
        }
        throw new IllegalArgumentException( "FlightStatus not found: " + status);
    }

    FlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }


}
