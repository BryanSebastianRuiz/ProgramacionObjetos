import java.util.Map;

public class FlightManager {
    private final Map<String, Flight> flights;

    public FlightManager() {
        flights = Map.of(
                "ORDS-0001", new Flight(Destinations.US.name(), Destinations.UK.name(), "2024-04-30 14:00"),
                "LAXS-0002", new Flight(Destinations.US.name(), Destinations.MX.name(), "2024-05-01 12:00"),
                "CDGS-0003", new Flight(Destinations.CN.name(), Destinations.US.name(), "2024-05-02 10:00"),
                "TYOS-0004", new Flight(Destinations.JP.name(), Destinations.US.name(), "2024-05-03 15:00"),
                "CUNM-0005", new Flight(Destinations.MX.name(), Destinations.US.name(), "2024-05-04 13:00"),
                "LDNS-0006", new Flight(Destinations.UK.name(), Destinations.US.name(), "2024-05-05 11:00"),
                "HNDJ-0007", new Flight(Destinations.JP.name(), Destinations.CN.name(), "2024-05-06 16:00"),
                "CDGM-0008", new Flight(Destinations.CN.name(), Destinations.MX.name(), "2024-05-07 09:00"),
                "JFKU-0009", new Flight(Destinations.US.name(), Destinations.JP.name(), "2024-05-08 17:00"),
                "CUNU-0010", new Flight(Destinations.MX.name(), Destinations.UK.name(), "2024-05-09 08:00")
        );
    }

    public void displayFlightPanel() {
        System.out.println("Flight Panel:");
        for (Map.Entry<String, Flight> entry : flights.entrySet()) {
            Flight flight = entry.getValue();
            System.out.println("| Flight ID: " + entry.getKey() +
                    " | Origin: " + flight.getId().substring(0, 2) +
                    " | Destination: " + flight.getId().substring(2, 4) +
                    " | Price: $" + flight.getTicketPrice() +
                    " |");
        }
    }

    public void buyTicket(String flightId, String fullName, String phoneNumber, String emailAddress, String country, String seatSelection) {
        Flight flight = flights.get(flightId);
        if (flight != null) {
            flight.buyTicket(fullName, phoneNumber, emailAddress, country, seatSelection);
            System.out.println("Ticket purchased successfully. Ticket ID: " + flight.getTicket(seatSelection).getTicketId());
        } else {
            System.out.println("Specified flight not found.");
        }
    }

    public Ticket retrieveTicketDetails(String ticketId) {
        for (Flight flight : flights.values()) {
            Ticket ticket = flight.getTicket(ticketId);
            if (ticket != null) {
                System.out.println("\nTicket details for ticket ID " + ticketId + ":");
                System.out.println("Ticket ID: " + ticket.getTicketId());
                System.out.println("Flight ID: " + ticket.getFlightId());
                System.out.println("Full Name: " + ticket.getUserInfo().getFullName());
                System.out.println("Phone Number: " + ticket.getUserInfo().getPhoneNumber());
                System.out.println("Email Address: " + ticket.getUserInfo().getEmailAddress());
                System.out.println("Country: " + ticket.getUserInfo().getCountry());
                System.out.println("Flight Date: " + ticket.getFlightDate());
                System.out.println("Ticket Price: $" + ticket.getTicketPrice());
                System.out.println("\nFlight Information:");
                System.out.println("Flight ID: " + flight.getId());
                System.out.println("Origin: " + flight.getId().substring(0, 2));
                System.out.println("Destination: " + flight.getId().substring(2, 4));
                System.out.println("Departure Date and Time: " + flight.getDepartureDateTime());
                System.out.println("Departure Gate: " + flight.getGate());
                System.out.println("Ticket Price: $" + flight.getTicketPrice());
                return ticket;
            }
        }
        System.out.println("No ticket found with the specified ID.");
        return null;
    }

    public Flight getFlightById(String flightId) {
        return flights.get(flightId);
    }
}
