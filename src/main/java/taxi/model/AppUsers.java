package taxi.model;

import java.util.HashMap;

public class AppUsers {
    public HashMap<String, Customer> customers = new HashMap<>();
    final double FIRST_BOOKING_DISCOUNT_PERCENT = 0.25;
    final double ALTERNATE_BOOKING_DISCOUNT_PERCENT = 0.10;

    public double calculateDiscountPercent(Customer customer) {
        if (hasVisitedBefore(customer)) {
            if (numberOfVisits(customer) % 2 == 0)
                return ALTERNATE_BOOKING_DISCOUNT_PERCENT;
            else
                return 0;
        } else {
            return FIRST_BOOKING_DISCOUNT_PERCENT;
        }
    }

    private boolean hasVisitedBefore(Customer customer) {
        return customers.containsKey(customer.getMobileNumber());
    }

    private int numberOfVisits(Customer customer) {
        return customers.get(customer.getMobileNumber()).getNumberOfVisits();
    }

    public void saveCustomerDetails(Customer customer) {
        if (hasVisitedBefore(customer)) {
            customers.get(customer.getMobileNumber()).incrementVisitCount();
        } else {
            customer.incrementVisitCount();
            customers.put(customer.getMobileNumber(), customer);
        }
    }

}

