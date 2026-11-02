package com.gurvir.pokedex.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

public class PokemonDetailsTest {
    @Test
    void validConstructor() {
        Pokemon pokemon = new Pokemon(6, "Charizard");
        int height = 7;
        int weight = 69;
        List<String> types = List.of("fire", "flying");

        PokemonDetails test = new PokemonDetails(pokemon, height, weight, types);

        assertEquals("Charizard", test.getPokemon().getName());
        assertEquals(6, test.getPokemon().getId());
        assertEquals(7, test.getHeightDecimetres());
        assertEquals(0.7, test.getHeightMetres(), 0.000001);
        assertEquals(69, test.getWeightHectograms());
        assertEquals(6.9, test.getWeightKilograms(), 0.000001);
        assertEquals(List.of("fire", "flying"), test.getTypes());
    }

    @Test
    void rejectsInvalidPokemon() {
        Pokemon pokemon = null;
        int height = 60;
        int weight = 100;
        List<String> types = List.of("fire", "flying");

        assertThrows(
            IllegalArgumentException.class,
            () -> new PokemonDetails(pokemon, height, weight, types)
        );
    }

    @Test
    void rejectsNegativeHeight() {
        Pokemon pokemon = new Pokemon(6, "Charizard");
        int height = -1;
        int weight = 100;
        List<String> types = List.of("fire", "flying");

        assertThrows(
            IllegalArgumentException.class,
            () -> new PokemonDetails(pokemon, height, weight, types)
        );
    }

    @Test
    void rejectsZeroHeight() {
        Pokemon pokemon = new Pokemon(6, "Charizard");
        int height = 0;
        int weight = 100;
        List<String> types = List.of("fire", "flying");

        assertThrows(
            IllegalArgumentException.class,
            () -> new PokemonDetails(pokemon, height, weight, types)
        );
    }

    @Test
    void rejectsNegativeWeight() {
        Pokemon pokemon = new Pokemon(6, "Charizard");
        int height = 60;
        int weight = -1;
        List<String> types = List.of("fire", "flying");

        assertThrows(
            IllegalArgumentException.class,
            () -> new PokemonDetails(pokemon, height, weight, types)
        );
    }

    @Test
    void rejectsZeroWeight() {
        Pokemon pokemon = new Pokemon(6, "Charizard");
        int height = 60;
        int weight = 0;
        List<String> types = List.of("fire", "flying");

        assertThrows(
            IllegalArgumentException.class,
            () -> new PokemonDetails(pokemon, height, weight, types)
        );
    }

    @Test
    void rejectsNullTypeElement() {
        Pokemon pokemon = new Pokemon(6, "Charizard");
        int height = 60;
        int weight = 100;
        List<String> types = new ArrayList<>();

        types.add(null);

        assertThrows(
            IllegalArgumentException.class,
            () -> new PokemonDetails(pokemon, height, weight, types)
        );
    }

    @Test
    void rejectsEmptyTypeElement() {
        Pokemon pokemon = new Pokemon(6, "Charizard");
        int height = 60;
        int weight = 100;
        List<String> types = new ArrayList<>();

        types.add("");

        assertThrows(
            IllegalArgumentException.class,
            () -> new PokemonDetails(pokemon, height, weight, types)
        );
    }

    @Test
    void rejectsWhiteSpaceTypeElement() {
        Pokemon pokemon = new Pokemon(6, "Charizard");
        int height = 60;
        int weight = 100;
        List<String> types = new ArrayList<>();

        types.add(" ");

        assertThrows(
            IllegalArgumentException.class,
            () -> new PokemonDetails(pokemon, height, weight, types)
        );
    }

    @Test
    void rejectsNullType() {
        Pokemon pokemon = new Pokemon(6, "Charizard");
        int height = 60;
        int weight = 100;
        List<String> types = null;

        assertThrows(
            IllegalArgumentException.class,
            () -> new PokemonDetails(pokemon, height, weight, types)
        );
    }

    @Test
    void rejectsEmptyTypesList() {
        Pokemon pokemon = new Pokemon(6, "Charizard");
        int height = 60;
        int weight = 0;
        List<String> types = new ArrayList<>();

        assertThrows(
            IllegalArgumentException.class,
            () -> new PokemonDetails(pokemon, height, weight, types)
        );
    }

    @Test
    void modifyingOriginalListDoesNotChangeStoredTypes() {
        Pokemon pokemon = new Pokemon(6, "Charizard");
        int height = 60;
        int weight = 100;
        List<String> originalTypes = new ArrayList<>(List.of("fire", "flying"));

        PokemonDetails test = new PokemonDetails(pokemon, height, weight, originalTypes);

        originalTypes.add("electric");

        assertEquals(List.of("fire", "flying"), test.getTypes());
    }

    @Test
    void cannotModifyGetTypes() {
        Pokemon pokemon = new Pokemon(6, "Charizard");
        int height = 60;
        int weight = 100;
        List<String> types = List.of("fire", "flying");

        PokemonDetails test = new PokemonDetails(pokemon, height, weight, types);

        assertThrows(
            UnsupportedOperationException.class,
            () -> test.getTypes().add("invalid")
        );
    }
}
