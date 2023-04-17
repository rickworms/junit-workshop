package com.example.junitworkshop.model;

import static com.example.junitworkshop.WineTestHelper.pomerol;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class WineTest {

    @Test
    public void testProperties() {
        // Given
        final Wine wine = pomerol();

        // Then
        assertEquals("Pomerol", wine.getName());
        assertEquals("Château Petrus", wine.getHouse());
        assertEquals(750, wine.getMilliliters());
        assertEquals(List.of("Cabernet Sauvignon", "Merlot"), wine.getGrapes());
    }

    @Test
    public void testDrinking() {
        // Given
        final Wine wine = pomerol();
        assertEquals(750, wine.milliliters);

        // When
        wine.drink(150);

        // Then
        assertEquals(600, wine.milliliters);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDrinkingTooMuch() {
        // Given
        final Wine wine = pomerol();
        assertEquals(750, wine.milliliters);

        // When
        wine.drink(800);

        // Then exception
    }
}