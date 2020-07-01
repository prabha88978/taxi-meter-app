package controller;

import taxi.model.*;

public class Calculator {
    private MiniTaxi miniTaxi;
    private SedanTaxi sedanTaxi;
    private SUVTaxi suvTaxi;

    public Calculator() {
        suvTaxi = new SUVTaxi();
        miniTaxi = new MiniTaxi();
        sedanTaxi = new SedanTaxi();
    }

    public String calculate(AppUsers appUsers, Customer customer, int distanceRequested) throws InvalidAmountException {
        int miniTaxiAmount = getMiniTaxiAmount(distanceRequested);
        int sedanTaxiAmount = getSedanTaxiAmount(distanceRequested);
        int suvTaxiAmount = getSuvTaxiAmount(distanceRequested);
        System.out.println(miniTaxiAmount + "\n" + sedanTaxiAmount + "\n" + suvTaxiAmount);
        double totalMiniTaxiAmount = miniTaxiAmount,
                totalSedanTaxiAmount = sedanTaxiAmount,
                totalSuvTaxiAmount = suvTaxiAmount;
        if (customer.getMobileNumber() != null) {
            totalMiniTaxiAmount -= calculateDiscount(appUsers, customer, miniTaxiAmount);
            totalSedanTaxiAmount -= calculateDiscount(appUsers, customer, sedanTaxiAmount);
            totalSuvTaxiAmount -= calculateDiscount(appUsers, customer, suvTaxiAmount);
            appUsers.saveCustomerDetails(customer);
        }
        return format(totalMiniTaxiAmount, totalSedanTaxiAmount, totalSuvTaxiAmount);
    }


    private double calculateDiscount(AppUsers appUsers, Customer customer, int taxiAmount) {
        return taxiAmount * appUsers.calculateDiscountPercent(customer);
    }


    private int getMiniTaxiAmount(int requestedDistance) throws InvalidAmountException {
        return miniTaxi.getAmount(requestedDistance);
    }

    private int getSedanTaxiAmount(int requestedDistance) throws InvalidAmountException {
        return sedanTaxi.getAmount(requestedDistance);
    }

    private int getSuvTaxiAmount(int requestedDistance) {
        return suvTaxi.getAmount(requestedDistance);
    }

    private String format(double miniTaxiAmount, double sedanTaxiAmount, double suvTaxiAmount) {
        return String.format("Mini - Rs. %.2f, Sedan - Rs. %.2f, SUV - Rs. %.2f\n", miniTaxiAmount, sedanTaxiAmount, suvTaxiAmount);
    }
}
