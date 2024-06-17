package com.mailing.system.models;

import com.mailing.system.enums.DistributionPoints;

public class Letter extends Package {

    public Letter(User sender, User recipient, DistributionPoints distributionPoint) {
        super(sender, recipient, distributionPoint); // Calls the constructor of the superclass (Package) passing the given parameters
    }

    @Override
    public double estimatePrice() {
        return getDistributionPoint().getCostPerKg(); // Returns the cost per kilogram of the associated distribution point
    }
}
