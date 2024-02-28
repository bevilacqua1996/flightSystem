package org.bevilacqua1996.flightsystem.domain.vo;

import org.bevilacqua1996.flightsystem.application.ports.input.FlightDataInternalFetchInputPort;
import org.bevilacqua1996.flightsystem.application.ports.input.FlightDataSimpleInputPort;
import org.bevilacqua1996.flightsystem.application.usecases.FlightDataSimpleUserCases;

public enum InputPortEnum {
    FLIGHT_DATA_SIMPLE("FlightDataSimpleInputPort", new FlightDataSimpleInputPort()),
    FLIGHT_DATA_INTERNAL_FETCH("FlightDataInternalFetchInputPort", new FlightDataInternalFetchInputPort());

    private final String input;
    private final FlightDataSimpleUserCases flightDataSimpleUserCases;

    InputPortEnum(String input, FlightDataSimpleUserCases flightDataSimpleUserCases) {
        this.input = input;
        this.flightDataSimpleUserCases = flightDataSimpleUserCases;
    }

    public String getInput() {
        return input;
    }

    public FlightDataSimpleUserCases getFlightDataUserCase() {
        return flightDataSimpleUserCases;
    }

    public static FlightDataSimpleUserCases ofInputString(String input) {
        for(InputPortEnum inputEnum : InputPortEnum.values()) {
            if(inputEnum.getInput().equals(input)) {
                return inputEnum.flightDataSimpleUserCases;
            }
        }
        throw new RuntimeException( "Input Port not found: " + input);
    }
}
