package org.bevilacqua1996.flightsystem.domain.vo;

import java.util.UUID;

public class FlightDataID {

    private final UUID uuid;

    private FlightDataID(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public static FlightDataID withId(String id) {
        return new FlightDataID(UUID.fromString(id));
    }

    public static FlightDataID withoutId() {
        return new FlightDataID(UUID.randomUUID());
    }

    @Override
    public String toString() {
        return "FlightDataID: " + this.uuid;
    }
}
