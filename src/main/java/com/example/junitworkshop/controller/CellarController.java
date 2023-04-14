package com.example.junitworkshop.controller;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.junitworkshop.model.Cellar;
import com.example.junitworkshop.model.Wine;
import com.example.junitworkshop.service.CellarService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class CellarController {
    private final CellarService cellarService;

    @GetMapping
    public Collection<Cellar> getCellars() {
        return cellarService.getCellars();
    }

    @GetMapping("/{name}")
    public Cellar getCellar(@PathVariable String name) {
        return cellarService.findCellar(name).orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
    }

    @PostMapping()
    public Cellar createCellar(@RequestBody Cellar cellar) {
        return cellarService.addCellar(cellar);
    }

    @PostMapping("/{cellarName}")
    public Cellar addWine(@PathVariable String cellarName, @RequestBody Wine wine) {
        return cellarService.findCellar(cellarName)
                .map(cellar -> cellarService.addWine(cellar, wine))
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
    }

    @PutMapping("/{cellarName}/{wineName}/{milliliters}")
    public Wine drinkWine(@PathVariable String cellarName, @PathVariable String wineName, @PathVariable int milliliters) {
        final Wine wine = cellarService.findCellar(cellarName)
                .flatMap(cellar -> cellar.findWine(wineName))
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        wine.drink(milliliters);
        return wine;
    }
}
