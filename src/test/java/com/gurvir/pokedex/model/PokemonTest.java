package com.gurvir.pokedex.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PokemonTest {
    @Test
    void constructorStoresValidIdentity() {
        Pokemon pokemon = new Pokemon(25, "Pikachu");

        assertEquals(25, pokemon.getId());
        assertEquals("Pikachu", pokemon.getName());
    }

    @Test
    void constructorRejectsZeroId() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Pokemon(0, "Pikachu")
        );
    }

    @Test
    void constructorRejectsNegativeId() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Pokemon(-1, "Pikachu")
        );
    }

    @Test 
    void constructorRejectsNullName() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Pokemon(1, null)
        );
    }

    @Test 
    void constructorRejectsEmptyName() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Pokemon(1, "")
        );
    }

    @Test 
    void constructorRejectsWhitespaceOnlyName() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Pokemon(1, " ")
        );
    }
}