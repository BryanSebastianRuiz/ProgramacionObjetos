package org.bookyourflights;

import java.util.List;
import java.util.Map;

public interface Flight implements FlightInterface {
	
	private String Id;
	private String DepartureGate;
	private List<char[]> Map;
	private Map<String, Ticket> Tickets;
	private Destination Origin;
	private Destination Destination;
	
	public Flight(Destination origin, Destination destination) {
		
		this.Origin = origin;
		this.Destination = destination;
	}
	

}
