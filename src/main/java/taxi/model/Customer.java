package taxi.model;

public class Customer {
    private static String mobileNumber;
    private static int requestedDistance;


    public Customer(String mobileNumber, int requestedDistance) {
        this.mobileNumber = mobileNumber;
        this.requestedDistance = requestedDistance;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public int getRequestedDistance() {
        return requestedDistance;
    }
}
