package model;

import org.junit.Test;
import taxi.model.SUVTaxi;

import static org.junit.Assert.assertEquals;

public class SUVTaxiTest {
    @Test
    public void testShouldReturnTheBaseAmount() {
        SUVTaxi suvTaxi = new SUVTaxi();
        int expectedAmount = 175;

        int actualAmount = suvTaxi.getAmount(10);

        assertEquals(expectedAmount, actualAmount);
    }

    @Test
    public void testShouldReturnTheAmountWhenTheDistanceIsMoreThanFlatDistance() {
        SUVTaxi sedanTaxi = new SUVTaxi();
        int expectedAmount = 1525;

        int actualAmount = sedanTaxi.getAmount(120);

        assertEquals(expectedAmount, actualAmount);
    }

    @Test
    public void testShouldReturnTheAmountWithAdditionalCost() {
        SUVTaxi sedanTaxi = new SUVTaxi();
        int expectedAmount = 325;

        int actualAmount = sedanTaxi.getAmount(20);

        assertEquals(expectedAmount, actualAmount);
    }
}
