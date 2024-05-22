package org.bookyourflights;

import org.bookyourflight.user.User;

public interface TicketInterface {
	/*
	 * This method retrieves the ticket
	 * id
	 */
	public String getTicketId();
	public String getFlight();
	public String getUser();
	public double getTicketPriece();

}
