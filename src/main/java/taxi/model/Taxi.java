package taxi.model;

public abstract class Taxi {
    private static int baseDistance;
    private static int basePrice;
    private static int mediumDistance;
    private static int mediumPricePerKM;
    private static int additionalDistanceCostPerKM;
    private static int flatDistance;
    private static int flatDistancePerKilometer;

    Taxi(int baseDistance, int basePrice, int mediumDistance, int mediumPricePerKM, int additionalDistanceCostPerKM, int flatDistance, int flatDistancePerKilometer) {
        this.baseDistance = baseDistance;
        this.basePrice = basePrice;
        this.mediumDistance = mediumDistance;
        this.mediumPricePerKM = mediumPricePerKM;
        this.additionalDistanceCostPerKM = additionalDistanceCostPerKM;
        this.flatDistance = flatDistance;
        this.flatDistancePerKilometer = flatDistancePerKilometer;
    }

    Taxi(int baseDistance, int basePrice, int mediumDistance, int mediumPricePerKM, int additionalDistanceCostPerKM) {
        this.baseDistance = baseDistance;
        this.basePrice = basePrice;
        this.mediumDistance = mediumDistance;
        this.mediumPricePerKM = mediumPricePerKM;
        this.additionalDistanceCostPerKM = additionalDistanceCostPerKM;
    }

    public int getAmount(int requestedDistance) {
        int totalAmount;
        if (isMore(requestedDistance))
            totalAmount = getFlatCost(requestedDistance);
        else {
            totalAmount = calculateTariff(requestedDistance);
        }
        return totalAmount;
    }

    private static boolean isMore(int requestedDistance) {
        return requestedDistance > flatDistance;
    }

    private static int getFlatCost(int requestedDistance) {
        return requestedDistance * flatDistancePerKilometer;
    }

    static int calculateTariff(int requestedDistance) {
        int amount = 0;
        amount += addBaseCost(requestedDistance);
        requestedDistance -= baseDistance;
        amount += addMediumBaseCost(requestedDistance);
        requestedDistance = requestedDistance - mediumDistance;
        amount += addExtraTravelCost(requestedDistance);
        return amount;
    }


    private static int addExtraTravelCost(int requestedDistance) {
        if (isaPositive(requestedDistance))
            return requestedDistance * additionalDistanceCostPerKM;
        return 0;
    }

    private static int addMediumBaseCost(int requestedDistance) {
        if (isaPositive(requestedDistance)) {
            if (requestedDistance >= mediumDistance)
                return mediumDistance * mediumPricePerKM;
            else
                return requestedDistance * mediumPricePerKM;
        }
        return 0;
    }

    private static int addBaseCost(int requestedDistance) {
        if (isaPositive(requestedDistance))
            return basePrice;
        return 0;
    }


    private static boolean isaPositive(int requestedDistance) {
        return requestedDistance > 0;
    }
}
