package com.gurvir.pokedex.ui;

import com.gurvir.pokedex.model.Pokemon;

import javafx.scene.layout.BorderPane;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.Parent;

public class PokedexView {
    private final BorderPane root;
    private final Label statusLabel;

    public PokedexView(final ObservableList<Pokemon> pokemon) {
        Label detailLabel = new Label("Select a Pokemon");
        ListView<Pokemon> pokemonList = new ListView<>(pokemon);

        pokemonList.getSelectionModel()
            .selectedItemProperty()
            .addListener((observable, oldPokemon, newPokemon) -> {
                if (newPokemon == null) {
                    detailLabel.setText("Select a Pokemon");
                } else {
                    detailLabel.setText("#" + newPokemon.getId() + " " + newPokemon.getName());
                }
            });

        this.statusLabel = new Label("Ready");

        pokemonList.setPrefWidth(220);
        this.root = new BorderPane();
        this.root.setTop(statusLabel);
        this.root.setLeft(pokemonList);
        this.root.setCenter(detailLabel);
    }

    public Parent getRoot() {
        return root;
    }

    public void setStatus(final String message) {
        statusLabel.setText(message);
    }
}
