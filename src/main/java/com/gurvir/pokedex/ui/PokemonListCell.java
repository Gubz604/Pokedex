package com.gurvir.pokedex.ui;

import java.util.Locale;

import com.gurvir.pokedex.model.Pokemon;
import javafx.scene.control.ListCell;

public class PokemonListCell extends ListCell<Pokemon> {
    @Override 
    protected void updateItem(final Pokemon pokemon, final boolean empty) {
        super.updateItem(pokemon, empty);

        if (empty || pokemon == null) {
            setText(null);
        } else {
            final String formattedPokemon = String.format(Locale.ROOT, "#%03d %s", pokemon.getId(), pokemon.getName());
            super.setText(formattedPokemon);
        }
    }
}
