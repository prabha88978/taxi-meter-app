package model;

import org.junit.Test;
import taxi.model.AppUsers;
import taxi.model.Customer;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class AppUsersTest {

    @Test
    public void testShouldReturnTrueWhenCustomerAlreadyVisitsBefore() {
        AppUsers appUsers = new AppUsers();
        Customer customer = new Customer("88978");
        appUsers.customers.put("88978", customer);
        Customer anotherCustomer = new Customer("88978");

        boolean contains = appUsers.customers.containsKey(anotherCustomer.getMobileNumber());

        assertTrue(contains);
    }

    @Test
    public void testShouldSaveTheCustomerDetails() {
        AppUsers appUsers = new AppUsers();
        Customer customer = new Customer("88978");
        int expectedNumberOfVisits = 1;
        appUsers.saveCustomerDetails(customer);

        int actualNumberOfVisits = appUsers.customers.get(customer.getMobileNumber()).getNumberOfVisits();

        assertEquals(expectedNumberOfVisits, actualNumberOfVisits);
    }

    @Test
    public void testShouldReturnTwoAsNumberOfPreviousVisitsWhenTheCustomerComesForThirdTime() {
        AppUsers appUsers = new AppUsers();
        Customer customer = new Customer("88978");
        Customer anotherCustomer = new Customer("88978");
        appUsers.saveCustomerDetails(customer);
        appUsers.saveCustomerDetails(anotherCustomer);
        Customer newCustomer = new Customer("88978");
        int expectedNumberOfVisits = 2;

        int actualNumberOfVisits = appUsers.customers.get(newCustomer.getMobileNumber()).getNumberOfVisits();

        assertEquals(expectedNumberOfVisits, actualNumberOfVisits);
    }

    @Test
    public void testShouldReturnZeroPointTwoFiveAsDiscountRateWhenUserComesForTheFirstTime() {
        AppUsers appUsers = new AppUsers();
        Customer customer = new Customer("88978");
        double expectedDiscountPercentage = 0.25;

        double discountPercentage = appUsers.calculateDiscountPercent(customer);

        assertEquals(expectedDiscountPercentage, discountPercentage);
    }

    @Test
    public void testShouldReturnZeroPointOneAsDiscountRateWhenUserComesForOnAlternateVisit() {
        AppUsers appUsers = new AppUsers();
        Customer customer = new Customer("88978");
        Customer anotherCustomer = new Customer("88978");
        appUsers.saveCustomerDetails(customer);
        appUsers.saveCustomerDetails(anotherCustomer);
        Customer newCustomer = new Customer("88978");
        double expectedDiscountPercentage = 0.10;

        double discountPercentage = appUsers.calculateDiscountPercent(newCustomer);

        assertEquals(expectedDiscountPercentage, discountPercentage);
    }


}
