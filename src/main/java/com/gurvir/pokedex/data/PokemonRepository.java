package com.gurvir.pokedex.data;

import com.gurvir.pokedex.model.Pokemon;
import java.util.List;

public interface PokemonRepository {
    List<Pokemon> findAll();
}