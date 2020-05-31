package controller;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OwnerTest {
    @Test
    public void testShouldReturnAmountsOfEachVehicle() {
        Owner owner = new Owner();
        String expectedCosts = "Mini - Rs. 120, Sedan - Rs. 140, SUV - Rs. 175\n";

        String actualCosts = owner.calculate(10);

        assertEquals(expectedCosts, actualCosts);

    }
}
