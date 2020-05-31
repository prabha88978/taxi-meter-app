package model;

import org.junit.Test;
import taxi.model.SedanTaxi;

import static org.junit.Assert.assertEquals;

public class SedanTaxiTest {
    @Test
    public void testShouldReturnTheAmount() {
        SedanTaxi sedanTaxi = new SedanTaxi();
        int expectedAmount = 810;

        int actualAmount = sedanTaxi.getAmount(75);

        assertEquals(expectedAmount, actualAmount);
    }

    @Test
    public void testShouldReturnTheAmountWhenTheDistanceIsMoreThanFlatDistance() {
        SedanTaxi sedanTaxi = new SedanTaxi();
        int expectedAmount = 860;

        int actualAmount = sedanTaxi.getAmount(80);

        assertEquals(expectedAmount, actualAmount);
    }

    @Test
    public void testShouldReturnTheAmountWithAdditionalCost() {
        SedanTaxi sedanTaxi = new SedanTaxi();
        int expectedAmount = 260;

        int actualAmount = sedanTaxi.getAmount(20);

        assertEquals(expectedAmount, actualAmount);
    }
}
