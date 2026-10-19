package com.gurvir.pokedex.model;

public class Pokemon {
    private final int id;
    private final String name;

    public Pokemon(final int id, final String name) {
        if (id <= 0) {
            throw new IllegalArgumentException("Pokemon ID must be greater than zero");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must exist and not be blank or empty");
        }
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override 
    public String toString() {
        return name;
    }
}