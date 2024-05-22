package org.bookyourflights;

import java.util.Random;
import org.bookyourflight.user.User;

public  class Ticket implements TicketInterface {
	
	private String Id = null;
	private Flight flight;
	private User user;
	private double TicketPriece;
	
	public Ticket(Flight flight, User user) {
		Random rand = new Random(9999);
		this.Id = "RE-" + rand.nextInt();
		this.Flight = flight;
		this.User = user;
		this.TicketPriece = rand.nextDouble();
	}
	
	public String getTicketId() {
		return this.Id;
	}
	public String getFlight() {
		return null;
	}
	public String getUser() {
		return null;
	}
	public double getTicketPriece() {
		return 0;
	}

}
