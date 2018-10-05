package com.apap.tutorial4.service;

import com.apap.tutorial4.model.FlightModel;

/**
 * FlightService
 * @author Ifdhal Suharmitan
 */

public interface FlightService {
	FlightModel getFlightDetailByFlightNumber(String flightNumber);
	void addFlight(FlightModel flight);
	void deleteFlight(FlightModel flight);
	void updateFlight(FlightModel flight, long id);
}
