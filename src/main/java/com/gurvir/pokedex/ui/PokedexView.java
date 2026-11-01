package com.gurvir.pokedex.ui;

import java.util.Locale;

import com.gurvir.pokedex.model.Pokemon;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.Parent;

public class PokedexView {
    private final BorderPane root;
    private final Label statusLabel;
    private final Button reloadButton;
    private final TextField searchField;

    public PokedexView(final ObservableList<Pokemon> pokemon) {
        Label detailLabel = new Label("Select a Pokemon");
        FilteredList<Pokemon> filteredPokemon = new FilteredList<>(pokemon);
        ListView<Pokemon> pokemonList = new ListView<>(filteredPokemon);
        
        pokemonList.setCellFactory(listView -> new PokemonListCell());

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
        this.reloadButton = new Button("Reload");
        this.searchField = new TextField();

        searchField.setPromptText("Search loaded Pokemon by name or ID");
        searchField.textProperty().addListener(
            (observable, oldText, newText) -> {
                String query = newText.strip().toLowerCase(Locale.ROOT);

                pokemonList.getSelectionModel().clearSelection();
                filteredPokemon.setPredicate(p -> {
                        return query.isEmpty() 
                        || p.getName().toLowerCase(Locale.ROOT).contains(query) 
                        || Integer.toString(p.getId()).equals(query);
                });
            }
        );

        HBox toolbar = new HBox(10, reloadButton, statusLabel);
        VBox header = new VBox(10, searchField, toolbar);

        pokemonList.setPrefWidth(220);
        this.root = new BorderPane();
        this.root.setTop(header);
        this.root.setLeft(pokemonList);
        this.root.setCenter(detailLabel);
    }

    public Parent getRoot() {
        return root;
    }

    public void setStatus(final String message) {
        statusLabel.setText(message);
    }

    public void setOnReload(Runnable action) {
        reloadButton.setOnAction(event -> action.run());
    }

    public void setLoading(final boolean loading) {
        reloadButton.setDisable(loading);
    }
}
