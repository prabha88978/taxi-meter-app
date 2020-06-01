package taxi.model;

import java.util.HashMap;

public class AppUsers extends HashMap<String, Customer> {
    public HashMap<String, Customer> customers = new HashMap<>();
    double FIRST_BOOKING_DISCOUNT_PERCENT = 0.25;
    double ALTERNATE_BOOKING_DISCOUNT_PERCENT = 0.10;

    public double calculateDiscountPercent(Customer customer) {
        if (isVisitedBefore(customer)) {
            if (numberOfVisits(customer) % 2 == 0)
                return ALTERNATE_BOOKING_DISCOUNT_PERCENT;
            else
                return 0;
        } else {
            return FIRST_BOOKING_DISCOUNT_PERCENT;
        }
    }

    private boolean isVisitedBefore(Customer customer) {
        return customers.containsKey(customer.getMobileNumber());
    }

    private int numberOfVisits(Customer customer) {
        return customers.get(customer.getMobileNumber()).getNumberOfVisits();
    }

    public void saveCustomerDetails(Customer customer) {
        if (isVisitedBefore(customer)) {
            customers.get(customer.getMobileNumber()).setVisitCount();
        } else {
            customer.setVisitCount();
            customers.put(customer.getMobileNumber(), customer);
        }
    }

}

