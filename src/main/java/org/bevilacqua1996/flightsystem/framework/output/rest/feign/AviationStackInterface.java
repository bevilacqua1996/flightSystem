package org.bevilacqua1996.flightsystem.framework.output.rest.feign;

import org.bevilacqua1996.flightsystem.framework.output.rest.data.JsonObjectFlight;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "AviationStackClient", url = "http://api.aviationstack.com/v1/flights")
public interface AviationStackInterface {

    @RequestMapping(method = RequestMethod.GET, consumes = "application/json")
    JsonObjectFlight getLastFlightData(@RequestParam("access_key") String accessKey, @RequestParam Integer limit);

}
