package org.bookyourflight.com;

import org.bookyourflights.Ticket;

public class Main {
	
	public static void main (String[] args) {
		Ticket t = new Ticket();
		t.Id = "faketicket";
		t.Flight = "The flight is: ";
		t.User = "The user asigneted";
		t.TicketPriece = "Priece invalid, try again";
		
		// TODO Auto-generated method stub
		System.out.println(t.getTicketId());
		
	}

}
