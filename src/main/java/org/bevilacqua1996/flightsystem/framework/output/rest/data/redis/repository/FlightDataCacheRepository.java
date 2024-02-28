package org.bevilacqua1996.flightsystem.framework.output.rest.data.redis.repository;

import org.bevilacqua1996.flightsystem.framework.output.rest.data.redis.entities.FlightDataCache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDataCacheRepository extends CrudRepository<FlightDataCache, String> {
}
