package model;

import org.junit.Test;
import taxi.model.Customer;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test
    public void testShouldReturnTheRequestedDistance() {
        Customer customer = new Customer(null, 10);
        int expectedRequestedDistance = 10;

        int actualRequestedDistance = customer.getRequestedDistance();

        assertEquals(expectedRequestedDistance, actualRequestedDistance);
    }

    @Test
    public void testShouldReturnTheCustomerName() {
        Customer customer = new Customer("8897888978", 10);
        String expectedCustomerMobileNumber = "8897888978";

        String actualCustomerMobileNumber = customer.getMobileNumber();

        assertEquals(expectedCustomerMobileNumber, actualCustomerMobileNumber);
    }
}
