package model;

import org.junit.Test;
import taxi.model.InvalidAmountException;
import taxi.model.MiniTaxi;

import static org.junit.Assert.assertEquals;

public class MiniTaxiTest {
    @Test
    public void testShouldReturnTheAmount() throws InvalidAmountException {
        MiniTaxi miniTaxi = new MiniTaxi();

        int expectedAmount = 656;

        int actualAmount = miniTaxi.getAmount(75);


        assertEquals(expectedAmount, actualAmount);
    }

    @Test
    public void testShouldReturnTheAmountWhenTheDistanceIsMoreThanFlatDistance() throws InvalidAmountException {
        MiniTaxi miniTaxi = new MiniTaxi();
        int expectedAmount = 608;

        int actualAmount = miniTaxi.getAmount(76);

        assertEquals(expectedAmount, actualAmount);
    }

    @Test
    public void testShouldReturnTheAmountWithAdditionalCost() throws InvalidAmountException {
        MiniTaxi miniTaxi = new MiniTaxi();
        int expectedAmount = 216;

        int actualAmount = miniTaxi.getAmount(20);

        assertEquals(expectedAmount, actualAmount);
    }

    @Test
    public void testShouldReturnTheAmountWithAdditionalCosts() throws InvalidAmountException {
        MiniTaxi miniTaxi = new MiniTaxi();
        int expectedAmount = 120;

        int actualAmount = miniTaxi.getAmount(10);

        assertEquals(expectedAmount, actualAmount);
    }
}
