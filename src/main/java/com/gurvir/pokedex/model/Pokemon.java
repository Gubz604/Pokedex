package com.gurvir.pokedex.model;

public class Pokemon {
    private final int id;
    private final String name;

    public Pokemon(final int id, final String name) {
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