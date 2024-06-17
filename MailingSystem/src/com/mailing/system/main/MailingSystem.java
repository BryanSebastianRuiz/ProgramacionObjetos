package com.mailing.system.main;

import java.util.Scanner;

import com.mailing.system.enums.DistributionPoints;
import com.mailing.system.exceptions.UserException;
import com.mailing.system.models.*;
import com.mailing.system.models.Package;

public class MailingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter sender's full name:");
            String senderName = scanner.nextLine();
            System.out.println("Enter sender's address:");
            String senderAddress = scanner.nextLine();
            System.out.println("Enter sender's phone number:");
            String senderPhone = scanner.nextLine();
            System.out.println("Enter sender's email:");
            String senderEmail = scanner.nextLine();
            User sender = new User(senderName, senderAddress, senderPhone, senderEmail); // Create a User object with the sender information
 
            System.out.println("Enter recipient's full name:");
            String recipientName = scanner.nextLine();
            System.out.println("Enter recipient's address:");
            String recipientAddress = scanner.nextLine();
            System.out.println("Enter recipient's phone number:");
            String recipientPhone = scanner.nextLine();
            System.out.println("Enter recipient's email:");
            String recipientEmail = scanner.nextLine();
            User recipient = new User(recipientName, recipientAddress, recipientPhone, recipientEmail); // Create a User object with the recipient's information

            System.out.println("Enter the destination state code (OAX, QROO, MOR, QRO, SIN):");
            String destinationCode = scanner.nextLine();
            DistributionPoints destination = null;
            for (DistributionPoints point : DistributionPoints.values()) { // Find the destination in the Distribution Points enumeration
                if (point.getCode().equalsIgnoreCase(destinationCode)) {
                    destination = point;
                    break;
                }
            }
            if (destination == null) { // Check if the destination is valid
                System.out.println("Invalid destination. Exiting...");
                return;
            }

            System.out.println("Is it a letter or a package? (L/P):");
            String type = scanner.nextLine();
            Package mailItem;
            if (type.equalsIgnoreCase("L")) { // Create a Letter object if it is a letter
                mailItem = new Letter(sender, recipient, destination);
            } else if (type.equalsIgnoreCase("P")) {
                System.out.println("Enter package weight (kg):");
                double weight = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Enter package description:");
                String description = scanner.nextLine();
                mailItem = new MailItem(sender, recipient, destination, weight, description); // Create a MailItem object if it is a package
            } else {
                System.out.println("Invalid type. Exiting...");
                return;
            }

            System.out.println("Estimated arrival time: " + mailItem.getEstimateArrival());
            System.out.println("Estimated cost: $" + mailItem.estimatePrice());

        } catch (UserException e) { // Catch and handle the UserException
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }
}
