package controller;

import taxi.model.*;

public class Calculator {
    AppUsers appUsers = new AppUsers();

    public String calculate(Customer customer, int distanceRequested) {
        int miniTaxiAmount = getMiniTaxiAmount(distanceRequested);
        int sedanTaxiAmount = getSedanTaxiAmount(distanceRequested);
        int suvTaxiAmount = getSuvTaxiAmount(distanceRequested);
        double totalMiniTaxiAmount = miniTaxiAmount,
                totalSedanTaxiAmount = sedanTaxiAmount,
                totalSuvTaxiAmount = suvTaxiAmount;
        if (customer.getMobileNumber() != null) {
            totalMiniTaxiAmount -= calculateDiscount(customer, miniTaxiAmount);
            totalSedanTaxiAmount -= calculateDiscount(customer, sedanTaxiAmount);
            totalSuvTaxiAmount -= calculateDiscount(customer, suvTaxiAmount);
            appUsers.saveCustomerDetails(customer);
        }
        return format(totalMiniTaxiAmount, totalSedanTaxiAmount, totalSuvTaxiAmount);
    }


    private double calculateDiscount(Customer customer, int taxiAmount) {
        return taxiAmount * appUsers.calculateDiscountPercent(customer);
    }


    private int getMiniTaxiAmount(int requestedDistance) {
        MiniTaxi miniTaxi = new MiniTaxi();
        return miniTaxi.getAmount(requestedDistance);
    }

    private int getSedanTaxiAmount(int requestedDistance) {
        SedanTaxi sedanTaxi = new SedanTaxi();
        return sedanTaxi.getAmount(requestedDistance);
    }

    private int getSuvTaxiAmount(int requestedDistance) {
        SUVTaxi suvTaxi = new SUVTaxi();
        return suvTaxi.getAmount(requestedDistance);
    }

    private String format(double miniTaxiAmount, double sedanTaxiAmount, double suvTaxiAmount) {
        return "Mini - Rs. " + miniTaxiAmount +
                ", Sedan - Rs. " + sedanTaxiAmount +
                ", SUV - Rs. " + suvTaxiAmount + "\n";
    }
}
