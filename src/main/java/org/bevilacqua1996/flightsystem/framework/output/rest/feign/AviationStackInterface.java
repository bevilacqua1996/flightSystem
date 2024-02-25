package org.bevilacqua1996.flightsystem.framework.output.rest.feign;

import org.bevilacqua1996.flightsystem.framework.output.rest.data.FlightDataDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "AviationStackClient", url = "http://api.aviationstack.com/v1/flights")
public interface AviationStackInterface {

    @RequestMapping(method = RequestMethod.GET, consumes = "application/json")
    List<FlightDataDTO> getLastFlightData(@RequestParam("access_key") String accessKey, @RequestParam Integer limit);

}
