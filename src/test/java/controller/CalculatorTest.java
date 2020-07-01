package controller;

import org.junit.Test;
import taxi.model.*;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void testShouldReturnAmountsOfEachVehicle() throws InvalidAmountException {
        Calculator calculator = new Calculator();
        String expectedCosts = "Mini - Rs. 120.00, Sedan - Rs. 140.00, SUV - Rs. 175.00\n";
        AppUsers appUsers = new AppUsers();

        String actualCosts = calculator.calculate(appUsers, new Customer(null), 10);

        assertEquals(expectedCosts, actualCosts);

    }

    @Test
    public void testShouldReturnAmountsOfEachVehicleWhenPhoneNumberAndDistanceAreGiven() throws InvalidAmountException {
        Calculator calculator = new Calculator();
        String expectedCosts = "Mini - Rs. 90.00, Sedan - Rs. 105.00, SUV - Rs. 131.25\n";
        AppUsers appUsers = new AppUsers();

        String actualCosts = calculator.calculate(appUsers, new Customer("8897853918"), 10);

        assertEquals(expectedCosts, actualCosts);

    }

    @Test
    public void testShouldReturnAmountsOfEachVehicleWhenCostumerComesNextTime() throws InvalidAmountException {
        Calculator calculator = new Calculator();
        String firstTimeExpectedCosts = "Mini - Rs. 90.00, Sedan - Rs. 105.00, SUV - Rs. 131.25\n";
        String secondTImeExpectedCosts = "Mini - Rs. 120.00, Sedan - Rs. 140.00, SUV - Rs. 175.00\n";
        String thirdTimeExpectedCosts = "Mini - Rs. 108.00, Sedan - Rs. 126.00, SUV - Rs. 157.50\n";
        AppUsers appUsers = new AppUsers();

        String actualCosts = calculator.calculate(appUsers, new Customer("8897853918"), 10);
        String secondTimeActualCosts = calculator.calculate(appUsers, new Customer("8897853918"), 10);
        String thirdTimeActualCosts = calculator.calculate(appUsers, new Customer("8897853918"), 10);

        assertEquals(firstTimeExpectedCosts, actualCosts);
        assertEquals(secondTImeExpectedCosts, secondTimeActualCosts);
        assertEquals(thirdTimeExpectedCosts, thirdTimeActualCosts);

    }
}
