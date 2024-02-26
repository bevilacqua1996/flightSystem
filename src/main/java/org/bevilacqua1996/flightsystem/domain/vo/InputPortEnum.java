package org.bevilacqua1996.flightsystem.domain.vo;

import org.bevilacqua1996.flightsystem.application.ports.input.FlightDataInputPort;
import org.bevilacqua1996.flightsystem.application.usecases.FlightDataUserCase;

public enum InputPortEnum {
    FLIGHT_DATA("FlightDataInputPort", new FlightDataInputPort());

    private final String input;
    private final FlightDataUserCase flightDataUserCase;

    InputPortEnum(String input, FlightDataUserCase flightDataUserCase) {
        this.input = input;
        this.flightDataUserCase = flightDataUserCase;
    }

    public String getInput() {
        return input;
    }

    public FlightDataUserCase getFlightDataUserCase() {
        return flightDataUserCase;
    }

    public static FlightDataUserCase ofInputString(String input) {
        for(InputPortEnum inputEnum : InputPortEnum.values()) {
            if(inputEnum.getInput().equals(input)) {
                return inputEnum.flightDataUserCase;
            }
        }
        throw new RuntimeException( "Input Port not found: " + input);
    }
}
