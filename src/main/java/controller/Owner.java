package controller;

import taxi.model.Customer;
import taxi.model.MiniTaxi;
import taxi.model.SUVTaxi;
import taxi.model.SedanTaxi;

import java.util.HashMap;
import java.util.Map;

public class Owner {
    Map<String, Integer> phoneNumbers = new HashMap<>();
    double FIRST_BOOKING_DISCOUNT = 0.25;
    double ALTERNATE_BOOKING_DISCOUNT = 0.10;

    public String calculate(Customer customer) {
        int miniTaxiAmount = getMiniTaxiAmount(customer.getRequestedDistance());
        int sedanTaxiAmount = getSedanTaxiAmount(customer.getRequestedDistance());
        int suvTaxiAmount = getSuvTaxiAmount(customer.getRequestedDistance());

        double totalMiniTaxiAmount = miniTaxiAmount, totalSedanTaxiAmount = sedanTaxiAmount, totalSuvTaxiAmount = suvTaxiAmount;
        if (customer.getMobileNumber() != null) {
            totalMiniTaxiAmount -= calculateDiscount(customer.getMobileNumber(), miniTaxiAmount);
            totalSedanTaxiAmount -= calculateDiscount(customer.getMobileNumber(), sedanTaxiAmount);
            totalSuvTaxiAmount -= calculateDiscount(customer.getMobileNumber(), suvTaxiAmount);
            saveContact(customer);
        }

        return format(totalMiniTaxiAmount, totalSedanTaxiAmount, totalSuvTaxiAmount);
    }


    private double calculateDiscount(String mobileNumber, int taxiAmount) {
        if (isVisited(mobileNumber)) {
            if (phoneNumbers.get(mobileNumber) % 2 == 0)
                return taxiAmount * ALTERNATE_BOOKING_DISCOUNT;
            else
                return 0;
        } else {
            return taxiAmount * FIRST_BOOKING_DISCOUNT;
        }
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

    private void saveContact(Customer customer) {
        if (isVisited(customer.getMobileNumber()))
            phoneNumbers.put(customer.getMobileNumber(), phoneNumbers.get(customer.getMobileNumber()) + 1);
        else phoneNumbers.put(customer.getMobileNumber(), 1);
    }

    private boolean isVisited(String mobileNumber) {
        return phoneNumbers.containsKey(mobileNumber);
    }

    private String format(double miniTaxiAmount, double sedanTaxiAmount, double suvTaxiAmount) {
        return "Mini - Rs. " + miniTaxiAmount +
                ", Sedan - Rs. " + sedanTaxiAmount +
                ", SUV - Rs. " + suvTaxiAmount + "\n";
    }
}
