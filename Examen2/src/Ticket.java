import java.util.Random;

public class Ticket {
    private final String ticketId;
    private final String flightId;
    private final UserInfo userInfo;
    private final String date;
    private final double ticketPrice;

    public Ticket(String flightId, UserInfo userInfo, String date, double ticketPrice) {
        this.ticketId = generateTicketId();
        this.flightId = flightId;
        this.userInfo = userInfo;
        this.date = date;
        this.ticketPrice = ticketPrice;
    }

    private String generateTicketId() {
        Random random = new Random();
        int randomId = random.nextInt(10000);
        return "RE-" + String.format("%04d", randomId);
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getFlightId() {
        return flightId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public String getDate() {
        return date;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}
