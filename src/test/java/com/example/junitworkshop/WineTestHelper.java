package com.example.junitworkshop;

import java.util.List;

import com.example.junitworkshop.model.Wine;

public class WineTestHelper {
    private WineTestHelper() {
    }

    public static Wine pomerol() {
        final Wine wine = new Wine();
        wine.setName("Pomerol");
        wine.setHouse("Château Petrus");
        wine.setMilliliters(750);
        wine.setGrapes(List.of("Cabernet Sauvignon", "Merlot"));

        return wine;
    }
}
