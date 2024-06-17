package com.mailing.system.enums;

public enum DistributionPoints {

	OAXACA("OAX", 48.2, 2.50), // Constant OAXACA with code "OAX", arrival time 48.2 hours, and cost per kg 2.50 USD
	QUINTANAROO("QROO", 36.5, 3.70), // QUINTANAROO constant with code "QROO", arrival time 36.5 hours, and cost per kg 3.70 USD
	MORELOS("MOR", 18.4, 1.60), // MORELOS constant with code "MOR", arrival time 18.4 hours, and cost per kg 1.60 USD
	QUERETARO("QRO", 35.3, 3.0), // QUERETARO constant with code "QRO", arrival time 35.3 hours, and cost per kg 3.0 USD
	SINALOA("SIN", 48.4, 4.0); // Constant SINALOA with code "SIN", arrival time 48.4 hours, and cost per kg 4.0 USD

    private final String code; 
    private final double arrivalTime; 
    private final double costPerKg; 

    DistributionPoints(String code, double arrivalTime, double costPerKg) {
        this.code = code;
        this.arrivalTime = arrivalTime;
        this.costPerKg = costPerKg;
    }

    public String getCode() { // Getter method to get the distribution point code
        return code;
    }

    public double getArrivalTime() { // Getter method to get the arrival time of the distribution point
        return arrivalTime;
    }

    public double getCostPerKg() { // Getter method to obtain the cost per kilogram of the distribution point
        return costPerKg;
    }
}
