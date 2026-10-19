package com.gurvir.pokedex.api;

import java.io.IOException;

public class ApiPreview {
    public static void main(String[] args)
            throws IOException, InterruptedException {
        
        PokeApiClient client = new PokeApiClient();
        String preview = client.fetchPokemonListJson();
        System.out.println(preview);
    }
}
