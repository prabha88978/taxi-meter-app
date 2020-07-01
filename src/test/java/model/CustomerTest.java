package model;

import org.junit.Test;
import taxi.model.Customer;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Test
    public void testShouldReturnTheCustomerPhoneNumber() {
        Customer customer = new Customer("8897888978");
        String expectedCustomerMobileNumber = "8897888978";

        String actualCustomerMobileNumber = customer.getMobileNumber();

        assertEquals(expectedCustomerMobileNumber, actualCustomerMobileNumber);
    }

    @Test
    public void testShouldReturnTheNumberOfVisitsOfAUser() {
        Customer customer = new Customer("8897888978");
        int expectedNumberOfVisits = 0;

        int actualNumberOfVisits = customer.getNumberOfVisits();

        assertEquals(expectedNumberOfVisits, actualNumberOfVisits);
    }

    @Test
    public void testShouldReturnOneAsNumberOfVisitsOfAUserAtSecondVisit() {
        Customer customer = new Customer("8897888978");
        customer.incrementVisitCount();
        int expectedNumberOfVisits = 1;

        int actualNumberOfVisits = customer.getNumberOfVisits();

        assertEquals(expectedNumberOfVisits, actualNumberOfVisits);
    }

    @Test
    public void testShouldSetTheNumberOfVisits() {
        Customer customer = new Customer("88978");
        int expectedSetCount = 1;

        customer.incrementVisitCount();
        int actualSetCount = customer.getNumberOfVisits();

        assertEquals(expectedSetCount, actualSetCount);
    }

}
