package taxi.model;


public class SUVTaxi extends Taxi {
    private static final int baseDistance = 5;
    private static final int basePrice = 100;
    private static final int mediumDistance = 15;
    private static final int mediumPricePerKM = 15;
    private static final int additionalDistanceCostPerKM = 12;

    public SUVTaxi() {
        super(baseDistance, basePrice, mediumDistance, mediumPricePerKM, additionalDistanceCostPerKM);
    }

    @Override
    public int getAmount(int requestedDistance) {
        return calculateTariff(requestedDistance);
    }

}
