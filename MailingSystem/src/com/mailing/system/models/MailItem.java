package com.mailing.system.models;

import com.mailing.system.enums.DistributionPoints;

public class MailItem extends Package {

    private double weight;
    private String description;

    public MailItem(User sender, User recipient, DistributionPoints distributionPoint, double weight, String description) {
        super(sender, recipient, distributionPoint); // Initializes the MailItem-specific attributes (weight and description) with the given values
        this.weight = weight;
        this.description = description;
    }

    public double getWeight() { // Method to obtain the weight of the package
        return weight;
    }

    public String getDescription() { // Method to get the description of the package contents
        return description;
    }

    @Override
    public double estimatePrice() {
        return weight * getDistributionPoint().getCostPerKg(); // Calculate the cost by multiplying the weight of the package by the cost per kilogram of the destination
    }
}
