import java.util.HashMap;
import java.util.Map;
import java.util.Random;

enum Destinations {
    MX("Mexico"), UK("United Kingdom"), US("United States"), JP("Japan"), CN("China");

    private final String name;

    Destinations(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Flight {
    private final String id;
    private final int numberSeats = 40;
    private final double ticketPrice;
    private final String dateTime;
    private final String gate;
    private final Map<String, Ticket> soldTickets = new HashMap<>();

    public Flight(String origin, String destination, String dateTime) {
        this.id = origin + destination + "-" + generateRandomNumber(10000);
        this.ticketPrice = generateRandomTicketPrice();
        this.dateTime = dateTime;
        this.gate = generateRandomGate();
    }

    private String generateRandomNumber(int bound) {
        R
