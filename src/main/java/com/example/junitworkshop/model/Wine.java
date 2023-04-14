package com.example.junitworkshop.model;

import java.util.List;

import lombok.Data;

@Data
public class Wine {
    String name;
    String house;
    int milliliters;
    List<String> grapes;

    public void drink(int milliliters) {
        if (this.milliliters < milliliters) {
            throw new IllegalArgumentException("No more wine left");
        }
        this.milliliters -= milliliters;
    }
}
