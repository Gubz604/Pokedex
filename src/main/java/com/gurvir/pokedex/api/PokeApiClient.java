package com.gurvir.pokedex.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class PokeApiClient {
    private final HttpClient client;

    public PokeApiClient() {
        this.client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();
    }

    public String fetchPokemonListJson() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://pokeapi.co/api/v2/pokemon?limit=3"))
            .timeout(Duration.ofSeconds(15))
            .GET()
            .build();

        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Failed to fetch Pokemon list: HTTP " + response.statusCode());
        }

        return response.body();
    }
}
