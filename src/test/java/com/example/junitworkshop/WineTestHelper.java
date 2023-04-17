package com.example.junitworkshop;

import java.util.Arrays;

import com.example.junitworkshop.model.Wine;

public class WineTestHelper {
    private WineTestHelper() {
    }

    public static Wine pomerol() {
        final Wine wine = new Wine();
        wine.setName("Pomerol");
        wine.setHouse("Château Petrus");
        wine.setMilliliters(750);
        wine.setGrapes(Arrays.asList("Cabernet Sauvignon", "Merlot"));

        return wine;
    }
}
