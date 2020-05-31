package controller;

import taxi.model.MiniTaxi;
import taxi.model.SUVTaxi;
import taxi.model.SedanTaxi;

public class Owner {
    public String calculate(int requestedDistance) {
        int miniTaxiAmount = getMiniTaxiAmount(requestedDistance);
        int sedanTaxiAmount = getSedanTaxiAmount(requestedDistance);
        int suvTaxiAmount = getSuvTaxiAmount(requestedDistance);
        return format(miniTaxiAmount, sedanTaxiAmount, suvTaxiAmount);
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

    private String format(int miniTaxiAmount, int sedanTaxiAmount, int suvTaxiAmount) {
        return "Mini - Rs. " + miniTaxiAmount +
                ", Sedan - Rs. " + sedanTaxiAmount +
                ", SUV - Rs. " + suvTaxiAmount + "\n";
    }
}
