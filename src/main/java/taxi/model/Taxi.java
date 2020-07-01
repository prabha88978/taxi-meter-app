package taxi.model;

public abstract class Taxi {
    private final int baseDistance;
    private final int basePrice;
    private final int mediumDistance;
    private final int mediumPricePerKM;
    private final int additionalDistanceCostPerKM;
    private int flatDistance;
    private int flatDistancePerKilometer;

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

    private boolean isMore(int requestedDistance) {
        System.out.println("Flat distance : \n" + flatDistance);
        return requestedDistance > flatDistance;
    }

    private int getFlatCost(int requestedDistance) {
        return requestedDistance * flatDistancePerKilometer;
    }

    int calculateTariff(int requestedDistance) {
        int amount = 0;
        amount += addBaseCost(requestedDistance);
        requestedDistance -= baseDistance;
        amount += addMediumBaseCost(requestedDistance);
        requestedDistance = requestedDistance - mediumDistance;
        amount += addExtraTravelCost(requestedDistance);
        return amount;
    }

    private int addExtraTravelCost(int requestedDistance) {
        if (requestedDistance > 0)
            return requestedDistance * additionalDistanceCostPerKM;
        return 0;
    }

    private int addMediumBaseCost(int requestedDistance) {
        if (requestedDistance > 0) {
            if (requestedDistance >= mediumDistance)
                return mediumDistance * mediumPricePerKM;
            else
                return requestedDistance * mediumPricePerKM;
        }
        return 0;
    }

    private int addBaseCost(int requestedDistance) {
        if (requestedDistance > 0)
            return basePrice;
        return 0;
    }

    public int getAmount(int requestedDistance) throws InvalidAmountException {
        int totalAmount;
        if(requestedDistance < 0){
            throw new InvalidAmountException();
        }
        if (isMore(requestedDistance))
            totalAmount = getFlatCost(requestedDistance);
        else {
            totalAmount = calculateTariff(requestedDistance);
        }
        return totalAmount;
    }
}
