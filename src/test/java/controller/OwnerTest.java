package controller;

import org.junit.Test;
import taxi.model.Customer;

import static org.junit.Assert.assertEquals;

public class OwnerTest {
    @Test
    public void testShouldReturnAmountsOfEachVehicle() {
        Owner owner = new Owner();
        String expectedCosts = "Mini - Rs. 120.0, Sedan - Rs. 140.0, SUV - Rs. 175.0\n";

        String actualCosts = owner.calculate(new Customer(null, 10));

        assertEquals(expectedCosts, actualCosts);

    }

    @Test
    public void testShouldReturnAmountsOfEachVehicleWhenPhoneNumberAndDistanceAreGiven() {
        Owner owner = new Owner();
        String expectedCosts = "Mini - Rs. 90.0, Sedan - Rs. 105.0, SUV - Rs. 131.25\n";

        String actualCosts = owner.calculate(new Customer("8897853918", 10));

        assertEquals(expectedCosts, actualCosts);

    }

    @Test
    public void testShouldReturnAmountsOfEachVehicleWhenCostumerComesNextTime() {
        Owner owner = new Owner();
        String firstTimeExpectedCosts = "Mini - Rs. 90.0, Sedan - Rs. 105.0, SUV - Rs. 131.25\n";
        String secondTImeExpectedCosts = "Mini - Rs. 120.0, Sedan - Rs. 140.0, SUV - Rs. 175.0\n";
        String thirdTimeExpectedCosts = "Mini - Rs. 108.0, Sedan - Rs. 126.0, SUV - Rs. 157.5\n";

        String actualCosts = owner.calculate(new Customer("8897853918", 10));
        String secondTimeActualCosts = owner.calculate(new Customer("8897853918", 10));
        String thirdTimeActualCosts = owner.calculate(new Customer("8897853918", 10));

        assertEquals(firstTimeExpectedCosts, actualCosts);
        assertEquals(secondTImeExpectedCosts, secondTimeActualCosts);
        assertEquals(thirdTimeExpectedCosts,thirdTimeActualCosts);

    }
}
