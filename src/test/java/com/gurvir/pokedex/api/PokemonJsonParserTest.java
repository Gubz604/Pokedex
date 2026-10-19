package com.gurvir.pokedex.api;

import org.junit.jupiter.api.Test;

import com.gurvir.pokedex.model.Pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

public class PokemonJsonParserTest {
    @Test 
    void parsesTwoPokemon() {
        String json = """
        {
        "results": [
            {
            "name": "pikachu",
            "url": "https://pokeapi.co/api/v2/pokemon/25/"
            },
            {
                "name": "squirtle",
                "url": "https://pokeapi.co/api/v2/pokemon/7/"
            }
        ]
        }
        """;
        PokemonJsonParser parser = new PokemonJsonParser();

        List<Pokemon> parsed = parser.parsePokemonList(json);

        assertEquals(2, parsed.size());

        assertEquals(25, parsed.get(0).getId());
        assertEquals("pikachu", parsed.get(0).getName());

        assertEquals(7, parsed.get(1).getId());
        assertEquals("squirtle", parsed.get(1).getName());
    }

    @Test
    void acceptsEmptyResults() {
        String json = """
        {
        "results": []
        }
        """;
        PokemonJsonParser parser = new PokemonJsonParser();

        List<Pokemon> parsed = parser.parsePokemonList(json);

        assertTrue(parsed.isEmpty());
    }

    @Test 
    void rejectsMissingResults() {
        String json = "{}";
        PokemonJsonParser parser = new PokemonJsonParser();
        assertThrows(
            IllegalArgumentException.class,
            () -> parser.parsePokemonList(json)
        );
    }

    @Test 
    void rejectsNullResults() {
        String json = """
        {"results": null}
        """;
        PokemonJsonParser parser = new PokemonJsonParser();
        assertThrows(
            IllegalArgumentException.class,
            () -> parser.parsePokemonList(json)
        );
    }
}
