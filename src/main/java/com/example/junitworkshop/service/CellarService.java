package com.example.junitworkshop.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.junitworkshop.model.Cellar;
import com.example.junitworkshop.model.Wine;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CellarService {
    private final Map<String, Cellar> cellars = new HashMap<>();

    public Collection<Cellar> getCellars() {
        return cellars.values();
    }

    public Optional<Cellar> findCellar(String name) {
        return Optional.ofNullable(cellars.get(name));
    }

    public Cellar addCellar(Cellar cellar) {
        if (cellars.get(cellar.getName()) != null) {
            throw new IllegalArgumentException("Cellar already exists");
        }
        cellars.put(cellar.getName(), cellar);

        return cellar;
    }

    public Cellar addWine(Cellar cellar, Wine wine) {
        cellar.getWines().add(wine);
        return cellar;
    }
}
