package com.gurvir.pokedex.api;

import java.io.IOException;
import java.util.List;

import com.gurvir.pokedex.data.ApiPokemonRepository;
import com.gurvir.pokedex.data.PokemonRepository;
import com.gurvir.pokedex.model.Pokemon;

public class ApiPreview {
    public static void main(String[] args)
            throws IOException, InterruptedException {

        PokemonRepository repository = new ApiPokemonRepository(new PokeApiClient(), new PokemonJsonParser());
        
        List<Pokemon> preview = repository.findAll();
        for (Pokemon pokemon : preview) {
            System.out.println("#" + pokemon.getId() + " " + pokemon.getName());
        }
    }
}
