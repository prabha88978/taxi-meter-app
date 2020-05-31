package taxi.model;

public class MiniTaxi extends Taxi {
    private static final int baseDistance = 3;
    private static final int basePrice = 50;
    private static final int mediumDistance = 15;
    private static final int mediumPricePerKilometer = 10;
    private static final int additionalDistanceCostPerKiloMeter = 8;
    private static final int flatDistance = 75;
    private static final int flatDistancePerKilometer = 8;

    public MiniTaxi() {
        super(baseDistance, basePrice, mediumDistance, mediumPricePerKilometer, additionalDistanceCostPerKiloMeter,
                flatDistance, flatDistancePerKilometer);
    }
}
