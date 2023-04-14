package com.example.junitworkshop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.Data;

@Data
public class Cellar {
    String name;
    List<Wine> wines = new ArrayList<>();

    public Optional<Wine> findWine(String name) {
        return wines.stream()
                .filter(wine -> wine.getName().equals(name))
                .findAny();
    }
}
