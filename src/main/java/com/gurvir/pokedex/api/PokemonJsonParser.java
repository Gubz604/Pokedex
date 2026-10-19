package com.gurvir.pokedex.api;

import com.gurvir.pokedex.model.Pokemon;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.net.URI;

import java.util.ArrayList;
import java.util.List;

public class PokemonJsonParser {
    public List<Pokemon> parsePokemonList(String json) {
        JsonObject root = JsonParser.parseString(json).getAsJsonObject();
        JsonElement resultElement = root.get("results");

        if (resultElement == null || resultElement.isJsonNull()) {
            throw new IllegalArgumentException("Pokemon response must contain results");
        }

        JsonArray results = resultElement.getAsJsonArray();

        List<Pokemon> pokemon = new ArrayList<>();

        for (JsonElement element :  results) {
            JsonObject entry = element.getAsJsonObject();
            String name = entry.get("name").getAsString();
            String url = entry.get("url").getAsString();

            String path = URI.create(url).getPath();
            String[] segments = path.split("/");
            String idText = segments[segments.length - 1];
            int id = Integer.parseInt(idText);

            pokemon.add(new Pokemon(id, name));
        }

        return List.copyOf(pokemon);
    }
}
