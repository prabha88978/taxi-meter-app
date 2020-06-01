package taxi.model;

public class Customer {
    private static String mobileNumber;
    private int numberOfVisits;

    public Customer(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        this.numberOfVisits = 0;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public int getNumberOfVisits() {
        return numberOfVisits;
    }

    public void setVisitCount() {
        numberOfVisits++;
    }
}
