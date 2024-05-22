import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FlightManager manager = new FlightManager();

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Display Flight Panel");
            System.out.println("2. Buy Ticket for a Flight");
            System.out.println("3. Retrieve Ticket Details");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Clear the input buffer

            switch (option) {
                case 1:
                    manager.displayFlightPanel();
                    break;
                case 2:
                    buyTicket(scanner, manager);
                    break;
                case 3:
                    retrieveTicketDetails(scanner, manager);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void buyTicket(Scanner scanner, FlightManager manager) {
        System.out.println("\nEnter your full name:");
        String fullName = scanner.nextLine();

        System.out.println("Enter your phone number:");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter your email address:");
        String emailAddress = scanner.nextLine();

        System.out.println("Enter your country:");
        String country = scanner.nextLine();

        System.out.println("Enter the flight ID to buy the ticket:");
        String flightId = scanner.nextLine();

        Flight flight = manager.getFlightById(flightId);
        if (flight != null) {
            System.out.println("Plane Map:");
            Map<String, String> planeMap = flight.getPlaneMap();
            for (Map.Entry<String, String> entry : planeMap.entrySet()) {
                String row = entry.getKey() + " |" + entry.getValue() + "|";
                row = row.replace("O", "OOO").replace("X", "XXX");
                System.out.println(row);
            }

            System.out.println("\nAvailable (O) and occupied (X) seats:");
            for (Map.Entry<String, String> entry : planeMap.entrySet()) {
                String row = entry.getValue();
                StringBuilder formattedRow = new StringBuilder();
                for (int i = 0; i < row.length(); i++) {
                    char seatStatus = row.charAt(i);
                    if (seatStatus == 'O') {
                        formattedRow.append("O");
                    } else {
                        formattedRow.append("X");
                    }
                }
                System.out.println(entry.getKey() + " |" + formattedRow + "|");
            }

            System.out.println("\nSelect a seat (row-seat, for example A-01):");
            String seatSelection = scanner.nextLine();
            manager.buyTicket(flightId, fullName, phoneNumber, emailAddress, country, seatSelection);
        } else {
            System.out.println("Specified flight not found.");
        }
    }

    private static void retrieveTicketDetails(Scanner scanner, FlightManager manager) {
        System.out.println("\nEnter the ticket ID to retrieve details:");
        String ticketId = scanner.nextLine();

        Ticket ticket = manager.retrieveTicketDetails(ticketId);
        if (ticket != null) {
            System.out.println("\nDo you want to see more details of the associated flight? (Yes/No):");
            String option = scanner.nextLine();
            if (option.equalsIgnoreCase("Yes")) {
                Flight flight = manager.getFlightById(ticket.getFlightId());
                if (flight != null) {
                    System.out.println("\nDetails of the associated flight:");
                    System.out.println("Flight ID: " + flight.getId());
                    System.out.println("Origin: " + flight.getId().substring(0, 2));
                    System.out.println("Destination: " + flight.getId().substring(2, 4));
                    System.out.println("Departure Date and Time: " + flight.getDepartureDateTime());
                    System.out.println("Departure Gate: " + flight.getGate());
                    System.out.println("Ticket Price: $" + flight.getTicketPrice());
                    System.out.println("Sold Seats:");
                    for (Map.Entry<String, Ticket> entry : flight.getSoldTickets().entrySet()) {
                        System.out.println("Seat: " + entry.getKey() +
                                " | Ticket ID: " + entry.getValue().getTicketId() +
                                " | Full Name: " + entry.getValue().getUserInfo().getFullName());
                    }
                } else {
                    System.out.println("Associated flight not found.");
                }
            }
        }
    }

}
