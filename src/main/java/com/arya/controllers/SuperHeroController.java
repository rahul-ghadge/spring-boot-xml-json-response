package com.arya.controllers;

import com.arya.model.SuperHero;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

@RestController
public class SuperHeroController {

    Supplier<List<SuperHero>> superHeroesSupplier = () ->
            Arrays.asList(
                    new SuperHero("Wade", "Deadpool", "Street fighter", 28, false),
                    new SuperHero("Bruce", "Hulk", "Doctor", 50, false),
                    new SuperHero("Steve", "Captain America", "Solder", 120, false),
                    new SuperHero("Tony", "Iron Man", "Business man", 45, true),
                    new SuperHero("Peter", "Spider Man", "Student", 21, true)
            );


    @GetMapping(value = "/super-heroes",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<SuperHero>> getSuperHeroes() {

        return ResponseEntity.ok(superHeroesSupplier.get());

    }


    @GetMapping(value = "/super-hero/{name}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<SuperHero> getSuperHeroByName(@Valid @PathVariable String name) throws Exception {

        SuperHero superHero = superHeroesSupplier
                .get()
                .stream()
                .filter(hero -> hero.getName().toLowerCase().equals(name.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Super hero not found with name " + name));

        return ResponseEntity.ok(superHero);

    }


}