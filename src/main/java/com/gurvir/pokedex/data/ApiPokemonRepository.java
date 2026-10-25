package com.gurvir.pokedex.data;

import java.io.IOException;
import java.util.List;

import com.gurvir.pokedex.api.PokeApiClient;
import com.gurvir.pokedex.api.PokemonJsonParser;
import com.gurvir.pokedex.model.Pokemon;

public class ApiPokemonRepository implements PokemonRepository {
    private final PokeApiClient client;
    private final PokemonJsonParser parser;

    public ApiPokemonRepository(final PokeApiClient client, final PokemonJsonParser parser) {
        this.client = client;
        this.parser = parser;
    }

    @Override
    public List<Pokemon> findAll() throws IOException, InterruptedException {
        String rawJson = client.fetchPokemonListJson();
        
        return parser.parsePokemonList(rawJson);
    }
}
