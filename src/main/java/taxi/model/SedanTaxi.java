package taxi.model;

public class SedanTaxi extends Taxi {
    private static final int baseDistance = 5;
    private static final int basePrice = 80;
    private static final int mediumDistance = 15;
    private static final int mediumPricePerKM = 12;
    private static final int additionalDistanceCostPerKM = 10;
    private static final int flatDistance = 100;
    private static final int flatDistancePerKM = 10;

    public SedanTaxi() {
        super(baseDistance, basePrice, mediumDistance, mediumPricePerKM,
                additionalDistanceCostPerKM, flatDistance, flatDistancePerKM);
    }
}
