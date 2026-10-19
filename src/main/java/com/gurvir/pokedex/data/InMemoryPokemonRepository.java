package com.gurvir.pokedex.data;

import com.gurvir.pokedex.model.Pokemon;

import java.util.List;

public class InMemoryPokemonRepository implements PokemonRepository {
    @Override 
    public List<Pokemon> findAll() {
        return List.of(
            new Pokemon(1, "Bulbasaur"),
            new Pokemon(4, "Charmander"),
            new Pokemon(7, "Squirtle")
        );
    }
}
