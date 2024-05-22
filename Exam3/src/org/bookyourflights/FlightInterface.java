package org.bookyourflights;
import java.util.List;

public interface FlightInterface {
	public String getId();
	public String getDepartureDate();
	public String getDepartureGate();
	public Ticket getTicket();
	public List<char[]> getMap();
	public void setMap(List<char[]> map);

}
