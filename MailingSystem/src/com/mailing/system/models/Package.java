package com.mailing.system.models;

import java.time.LocalDateTime;

import com.mailing.system.enums.DistributionPoints;

public abstract class Package {
    private User sender;
    private User recipient;
    private DistributionPoints distributionPoint;

    public Package(User sender, User recipient, DistributionPoints distributionPoint) {
        this.sender = sender;
        this.recipient = recipient;
        this.distributionPoint = distributionPoint;
    }
    public User getSender() { // Getter method to get the sender of the packet
        return sender;
    }

    public User getRecipient() { // Getter method to get the recipient of the packet
        return recipient;
    }

    public DistributionPoints getDistributionPoint() { // Getter method to get the package distribution point
        return distributionPoint;
    }

    public LocalDateTime getEstimateArrival() { // Method to calculate and obtain the estimated arrival time of the package
        return LocalDateTime.now().plusHours((long) distributionPoint.getArrivalTime()); // Gets the current time and adds the arrival time of the distribution point
    }

    public abstract double estimatePrice(); // Abstract method to estimate the package price
}
