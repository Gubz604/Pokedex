package com.gurvir.pokedex.model;

import java.util.List;

public class PokemonDetails {
    private final Pokemon pokemon;
    private final int heightDecimeters;
    private final int weightHectograms;
    private final List<String> types;

    public PokemonDetails(  
        final Pokemon pokemon, 
        final int heightDecimeters, 
        final int weightHectograms, 
        final List<String> types
    ) {
        if (pokemon == null || heightDecimeters <= 0 || weightHectograms <= 0) {
            throw new IllegalArgumentException("Invalid argument");
        }
        if (types == null || types.isEmpty()) {
            throw new IllegalArgumentException("Types must not be null or empty");
        }
        for (String type : types) {
            if (type == null || type.isBlank()) {
                throw new IllegalArgumentException("Type must not be null or blank");
            }
        }

        this.pokemon            = pokemon;
        this.heightDecimeters   = heightDecimeters;
        this.weightHectograms   = weightHectograms;
        this.types              = List.copyOf(types);
    }

    public Pokemon getPokemon() { return pokemon; }

    public int getHeightDecimetres() { return heightDecimeters; }

    public int getWeightHectograms() { return weightHectograms; }

    public List<String> getTypes() { return types; }

    public double getHeightMetres() {
        return heightDecimeters / 10.0;
    }
    public double getWeightKilograms() {
        return weightHectograms / 10.0;
    }
}
